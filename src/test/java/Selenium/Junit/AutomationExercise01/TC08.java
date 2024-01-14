package Selenium.Junit.AutomationExercise01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC08 {

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

        // Test Case 8: Register User
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Products' button
        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        // 6. The products list is visible
        // 7. Click on 'View Product' of first product
        // 8. User is landed to product detail page
        // 9. Verify that  detail is visible: product name, category, price, availability, condition, brand


        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed());
        Thread.sleep(1500);

        // 4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href='/products']")).click();

        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.cssSelector(".title.text-center")).isDisplayed());

        // 6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='advertisement']//div[@class='container']")).isDisplayed());

        // 7. Click on 'View Product' of first product
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();

        // 8. User is landed to product detail page
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='product-details']")).isDisplayed());

        // 9. Verify that detail is visible: product name, category, price, availability, condition, brand

        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Availability:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Condition:']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Brand:']")).isDisplayed());

    }
}
