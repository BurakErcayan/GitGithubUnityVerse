package Selenium.Junit.WindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class WindowHandlingBasicExample01 {
    WebDriver driver;

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
        driver.close();

    }
    @Test
    public void test01() throws InterruptedException {

        //1- https://www.trendyol.com/ web sitesine gidiniz.
        //2- halihazırda üzerinde çalıştığınız windowun hash codu'unu alınız.
        //3- searchbar'a "cüzdan" yazalım ve aratalım.
        //4- sonuçlar içerisinden 1. ürüne tıklayalım.
        //5- en altta bulunan "daha fazla bershka cüzdan" elementine tıklayınız.
        //6- açılan pencerede "kedi maması" arayınız.
        //7- 1. window'a dönünüz ve ve urlini consola yazdırınız.


        //1-
        driver.get("https://www.trendyol.com/");
        driver.findElement(By.xpath("//div[@id='gender-popup-app']//div[@class='modal-close']")).click();
        //2-
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        //3-
        driver.findElement(By.xpath("//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']"))
                .sendKeys("cüzdan" + Keys.ENTER);
        //4-
        driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//div[@class='p-card-chldrn-cntnr card-border'])[1]")).click();


        Set<String> hashCodelari = driver.getWindowHandles();

        System.out.println("ilk sayfanın hash codu: "+ ilkSayfaWindowHandleDegeri);
        System.out.println(hashCodelari);

        String ikinciSayfaWindowHandleDegeri="";


        for (String each: hashCodelari
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                System.out.println("aynı değil");
                ikinciSayfaWindowHandleDegeri=each;
            }else System.out.println("aynı hash codu");
        }

        System.out.println("ikinci sayfanin hash codu: "+ikinciSayfaWindowHandleDegeri);

        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);

        driver.findElement(By.xpath("//img[@alt='Bershka Cüzdan']")).click();
        Thread.sleep(5000);



        Set <String> hashCodelari2 = driver.getWindowHandles();

        System.out.println("ilk sayfanın hash codu: "+ ilkSayfaWindowHandleDegeri);
        System.out.println("ikinci sayfanin hash codu: "+ikinciSayfaWindowHandleDegeri);
        System.out.println(hashCodelari2);

        String ucuncuSayfaWindowHandleDegeri="";


        for (String each: hashCodelari2
        ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)   && !each.equals(ikinciSayfaWindowHandleDegeri) ){
                System.out.println("aynı değil");
                ucuncuSayfaWindowHandleDegeri=each;
            }else System.out.println("aynı hash codu");
        }

        System.out.println("üçüncü sayfanın hash codu: "+ ucuncuSayfaWindowHandleDegeri);








    }
}
