package mondayExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import javax.xml.crypto.dom.DOMCryptoContext;
import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class deneme2 {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){

        //driver.quit();
    }
    @Test
    public void test01() throws InterruptedException {
        // hepsiburada.com sitesine gidiniz.
        driver.get("https://www.hepsiburada.com");
        String windowsHandle1 =driver.getWindowHandle();
        //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
        WebElement elektronik= driver.findElement(By.xpath("//span[text()='Elektronik']"));
        Actions actions =new Actions(driver);
        actions.moveToElement(elektronik).perform();

        WebElement bilgisayar =  driver.findElement(By.xpath("//*[text()='Bilgisayar/Tablet']"));
        actions.moveToElement(bilgisayar).perform();
        Thread.sleep(2000);

        WebElement notebook =driver.findElement(By.xpath("//a[text()='Dizüstü Bilgisayar']"));
        notebook.click();
        //Sıralamalardan çok satanlara tıkla
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        driver.findElement(By.xpath("//*[text()='Sıralama']")).click();
        Thread.sleep(2000);

        WebElement cokSatanlar = driver.findElement(By.xpath("//div[text()='Çok satanlar']"));
        cokSatanlar.click();


            //marka olarak Apple markasını seç
         driver.findElement(By.xpath("//div[@id='markalar']//input[@value='apple']")).click();


        Thread.sleep(4000);
        //İlk çıkan ürüne git
       // driver.findElement(By.xpath("(//h3[@type='comfort'])[1]")).click();
       // //ilk çıkan ürüne gittikten sonra ek hizmet ekleye tıkla
       // String ikinciSayfaWhd = "";
       // Set<String> whdSeti = driver.getWindowHandles();
//
       // for (String each : whdSeti
       // ) {
       //     if (!each.equals(windowsHandle1)){
       //         ikinciSayfaWhd = each;
       //     }
       // }
       // driver.switchTo().window(ikinciSayfaWhd);
       // driver.findElement(By.xpath("//*[text()='Ekle']")).click();
       // //ürünü sepete ekle
       // driver.findElement(By.xpath("//button[@id='addToCart']")).click();
       // Thread.sleep(3000);
       // //sepete git ve sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.
       // driver.findElement(By.xpath("//*[text()='Sepetim']")).click();
       // //Sepete Git butonuna tıkla
       // //Sepetteki ürünün para birimi değerini consolda yazdır
       // //Browser ı kapat.
    }
    public  boolean checkAnyElementIsActiveOrDisplayedXPATH(String XPATHlocator) throws InterruptedException {
        Thread.sleep(5000);

        List<WebElement> elementList = driver.findElements(By.xpath(XPATHlocator));
        System.out.println(elementList.size());
        if (elementList.size() > 0) {
            // Element is present
            return true;
        } else {
            // Element is not present
            return false;
        }
    }
}



