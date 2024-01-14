package Selenium.Junit.ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class doubleClick01 {
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
    public void doubleclick01() throws InterruptedException {

        driver.get("https://demoqa.com/buttons");
        WebElement doubleClickbutton =driver.findElement(By.id("doubleClickBtn"));
        Actions actions=new Actions(driver);

        actions.doubleClick(doubleClickbutton).perform();

        Assert.assertTrue(driver.findElement(By.id("doubleClickMessage")).isDisplayed());

        WebElement rightClik =driver.findElement(By.id("rightClickBtn"));

        actions.doubleClick(rightClik).click();

    }
    //Git Github 1.deneme
    //Git Github 2.deneme
    //Git Github 1.deneme Burak branch'i
}
