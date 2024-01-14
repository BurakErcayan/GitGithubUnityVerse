package Selenium.Junit.AutomationExercise01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TC02 {
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
    public void automationExerciseTest() throws InterruptedException {


       // Test Case 2: Register User
       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Verify that home page is visible successfully
       // 4. Click on 'Signup / Login' button
       // 5. Verify 'Login to your account' is visible
       // 6. Enter correct email address and password
       // 7. Click 'login' button
       // 8. Verify that 'Logged in as username' is visible
       // 9. Click 'Delete Account' button
       // 10. Verify that 'ACCOUNT DELETED!' is visible

        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
        Thread.sleep(1500);


        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(3000);

        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).isDisplayed());
        Thread.sleep(1000);

        // 6. Enter correct email address and password
        WebElement mail = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        mail.sendKeys("burakercayan@gmail.com");
        WebElement sifre = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        sifre.sendKeys("123456");

        // 7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        // 8. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("li:nth-child(10) a:nth-child(1)")).isDisplayed());
        Thread.sleep(1500);

        // 9. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        Thread.sleep(1000);

        // 10. Verify that 'ACCOUNT DELETED!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']")).isDisplayed());

    }

}
