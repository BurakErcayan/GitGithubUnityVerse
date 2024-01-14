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

import java.time.Duration;

public class TC03 {
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


        // Test Case 3: Register User
       // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
       // 3. Verify that home page is visible successfully
       // 4. Click on 'Signup / Login' button
       // 5. Verify 'Login to your account' is visible
       // 6. Enter incorrect email address and password
       // 7. Click 'login' button
       // 8. Verify error 'Your email or password is incorrect!' is visible

        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        // 3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
        Thread.sleep(1000);


        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(1000);

        // 5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login-form'] h2")).isDisplayed());
        Thread.sleep(1000);

        // 6. Enter incorrect email address and password
        WebElement mail = driver.findElement(By.cssSelector("input[data-qa='login-email']"));
        mail.sendKeys("burakercayan01@gmail.com");
        WebElement sifre = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        sifre.sendKeys("1905");

        // 7. Click 'login' button
        driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

        // 8. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).isDisplayed());











    }


    }
