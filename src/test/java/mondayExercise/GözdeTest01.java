package mondayExercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class GözdeTest01 {

    WebDriver driver;

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(1500);
      // driver.close();

    }

    @Test
    public void TrendyolTest02() throws InterruptedException {

        //Test Case 1
        //1."https://www.trendyol.com.tr" web sitesine git
        //Giriş yap butonuna tıkla
        //2.E-mail adresinizi girin
        //3.Şifrenizi girin
        //4.giriş yap butonuna tıklayın
        //5.Çok satanlar kategorisine tıkla
        //6.Çıkan ilk ürünü favorilere ekleyin
        //7.ürüne tıklayın
        // 8.Ürünü sepete ekleyin.

        driver.get("https://www.hepsiburada.com/");


        // REKLAM KISMI KAPATMA
        driver.findElement(By.xpath("//*[text()='Kabul et']")).click();
        Thread.sleep(5000);



        WebElement AramaButonu = driver.findElement(By.xpath("//div[text()='Ürün, kategori veya marka ara']//ancestor::div[@style='justify-content:flex-start']"));
        AramaButonu.click();
        Thread.sleep(2000);

        WebElement AramaButonuAktif = driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        AramaButonuAktif.sendKeys("iphone"+Keys.ENTER);

       driver.get("https://www.hepsiburada.com/");
       String ilkPencerem = driver.getWindowHandle();
      // driver.findElement(By.xpath("//button[text()='KABUL ET']")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//a[text()='Çok Satanlar']/parent::li")).click();
       Thread.sleep(2000);
       WebElement ilkUrun = driver.findElement(By.xpath("//div[@class='rank-badge']//span[text()='1']"));
       ilkUrun.click();

       Set<String> tumPencereler = driver.getWindowHandles();
           for (String handle : tumPencereler) {
               if (!handle.equals(ilkPencerem)){
                   driver.switchTo().window(handle);
                   break;
               }
           }

       Thread.sleep(3000);
       driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']")).click();
       Thread.sleep(3000);
       driver.switchTo().window(ilkPencerem);
    }

}
