package Selenium.Junit.WindowHandling;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class deneme {

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
        //driver.close();

    }
    @Test
    public void doubleclick01() throws InterruptedException {



        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions =new Actions(driver);
        WebElement ciziliAlanSagTık =driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanSagTık).perform();




}}
