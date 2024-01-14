package Selenium.Junit.Hooks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BeforeAfterHooks {
    WebDriver driver;

    @Before
    public  void  SetUp(){
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
    public  void  method01() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");


    }
    @Test
    public  void  method02() throws InterruptedException {
        driver.get("https://www.facebook.com");

    }
    @Test
    public  void  method03() throws InterruptedException {
        driver.get("https://www.trendyol.com");

    }

}
