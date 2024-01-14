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

public class TC05 {
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

        // Test Case 5: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        //5. Verify 'New User Signup!' is visible
        //6. Enter name and already registered email address
        //7. Click 'Signup' button
        //8. Verify error 'Email Address already exist!' is visible

        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
        Thread.sleep(3000);

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
        Thread.sleep(3000);

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());
        Thread.sleep(3000);

        //6. Enter name and already registered email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).isDisplayed();
        WebElement isimGirisi = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        isimGirisi.sendKeys("Burak");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).isDisplayed();
        WebElement mailGirisi = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mailGirisi.sendKeys("burakercayan@gmail.com");
        Thread.sleep(1000);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();
        Thread.sleep(1000);

        //8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Email Address already exist!']")).isDisplayed());



    }



}
