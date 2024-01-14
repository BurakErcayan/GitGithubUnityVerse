package mondayExercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class TrendyolDeneme {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor Js;


    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }

    @Test
    public void TrendyolTest() throws InterruptedException {

        // Trendyol TestCase
        //1."https://www.trendyol.com/" Sayfasına git.
        //2.Mouse mizi "Erkek"  Katagorisinin üzerine bekletelim.
        //3."Tişört" sekmesine tıklayalım.
        //4."Çıkan  2. ürüne" Tıklayalım.
        //5."AC&Co / Altınyıldız Classics " Yazısı içerdiğini test edelim.
        //6."Renk seçeneklerinin üzerinde" mousemizi gezdirelim.
        //7."Beden" sekmesinden L bedeni seçelim.
        //8."SEPETE EKLE" Butonuna tıklayalım.
        //9."Sepetim" Butonuna tıklayalım.
        //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.


        //1."https://www.trendyol.com/" Sayfasına git.
            driver.get("https://www.trendyol.com/");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[text()='KABUL ET']")).click();
            String ilksayfaWhd = driver.getWindowHandle();

        //2.Mouse mizi "Erkek"  Katagorisinin üzerine getirelim.
            WebElement ErkekButonu = driver.findElement(By.xpath("//a[normalize-space()='Erkek']/parent::li"));
            Actions actions = new Actions(driver);
            Thread.sleep(2000);
            actions.moveToElement(ErkekButonu).perform();

        //3."Tişört" sekmesine tıklayalım.
            WebElement TisortButonu = driver.findElement(By.xpath("//div[@id='sub-nav-2']//a[contains(text(),'Tişört')]"));
            TisortButonu.click();
            Thread.sleep(1000);

        //4."Çıkan 2. ürüne" Tıklayalım.
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='p-card-chldrn-cntnr card-border']"));
            elementList.get(1).click();

            Set<String> TumPencereler = driver.getWindowHandles();
            String ikinciSayfamWhd = "";
            for (String handle : TumPencereler
        ) {
            if (!handle.equals(ilksayfaWhd)) {
                ikinciSayfamWhd = handle;
            }
        }
            driver.switchTo().window(ikinciSayfamWhd);
            Thread.sleep(1000);
           // WebElement urunKampanyaAnladimButton=driver.findElement(By.xpath("//div[text()='Anladım']"));
           // urunKampanyaAnladimButton.click();

        //5."AC&Co / Altınyıldız Classics " Yazısı içerdiğini test edelim.
            WebElement urunAdi =driver.findElement(By.xpath("//a[@class='product-brand-name-with-link']"));
            String expectedYazi = "GRIMELANGE";
            String actualYazi = urunAdi.getText();
            Assert.assertEquals(expectedYazi, actualYazi);

        //6."Renk seçeneklerinin üzerinde" mousemizi gezdirelim.
            Thread.sleep(1000);
            List<WebElement> Color = driver.findElements(By.xpath("//div[@class='slicing-attributes']/section//a"));
            for (int i = 0; i <Color.size(); i++) {
            actions.moveToElement(Color.get(i)).perform();
        }

        //7."Beden" sekmesinden L bedeni seçelim.
            driver.findElement(By.xpath("//div[normalize-space()='L']")).click();

        //8."SEPETE EKLE" Butonuna tıklayalım.
            driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();

        //9."Sepetim" Butonuna tıklayalım.
            driver.findElement(By.xpath("//i[@class='i-bagg-orange hover-icon']")).click();


         //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.
            driver.findElement(By.xpath("(//a[@class='ty-link-btn-primary'])[2]")).click();

            }
       }


