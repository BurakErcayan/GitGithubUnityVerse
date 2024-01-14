package mondayExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class hepsiBuradaTestCase {


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
        // driver.close();
    }

    @Test
     public void hepsiBuradaTest01() throws InterruptedException {

        driver.get("https://www.hepsiburada.com");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[text()='Kabul et']")).click();
        Thread.sleep(5000);



        WebElement AramaButonu = driver.findElement(By.xpath("//div[text()='Ürün, kategori veya marka ara']//ancestor::div[@style='justify-content:flex-start']"));
        AramaButonu.click();
        Thread.sleep(2000);

        WebElement AramaButonuAktif = driver.findElement(By.xpath("//input[@placeholder='Ürün, kategori veya marka ara']"));
        AramaButonuAktif.sendKeys("java"+Keys.ENTER);

        Thread.sleep(5000);



        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");







    }



}

