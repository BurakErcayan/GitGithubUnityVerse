package Selenium.Junit.ActionsClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionClassExamples01 {
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
    public void automationExerciseTest() throws InterruptedException {

        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        //3. Verify that home page is visible successfully
        //4. Click on 'Signup / Login' button
        //5. Verify 'New User Signup!' is visible
        //6. Enter name and email address
        //7. Click 'Signup' button
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'
        //14. Verify that 'ACCOUNT CREATED!' is visible
        //15. Click 'Continue' button
        //16. Verify that 'Logged in as username' is visible
        //17. Click 'Delete Account' button
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button

        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
        Thread.sleep(3000);

        //4. Click on 'Signup / Login' button
        WebElement singupButton =driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
        Actions action=new Actions(driver);
        action.click(singupButton).perform();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());
        Thread.sleep(3000);

        //6. Enter name and email address
        //7. Click 'Signup' button
        WebElement isimGirisi = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        action.click(isimGirisi)
                .sendKeys("burak")
                .sendKeys(Keys.TAB)
                .sendKeys("burakercayan100@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        //10. Select checkbox 'Sign up for our newsletter!'
        //11. Select checkbox 'Receive special offers from our partners!'
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //13. Click 'Create Account button'

        WebElement mr = driver.findElement(By.cssSelector("#id_gender1"));
        action.click(mr)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("123456")
                .sendKeys(Keys.TAB)
                .sendKeys("22")
                .sendKeys(Keys.TAB)
                .sendKeys("Noven")
                .sendKeys(Keys.TAB)
                .sendKeys("1987")

                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).perform();


        Thread.sleep(3000);

        WebElement isim = driver.findElement(By.id("first_name"));
        action.click(isim)
                .sendKeys("Burak")
                .sendKeys(Keys.TAB)
                .sendKeys("Ercayan")
                .sendKeys(Keys.TAB)
                .sendKeys("Asel Hukuk")
                .sendKeys(Keys.TAB)
                .sendKeys("Halkali")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("United States")
                .sendKeys(Keys.TAB)
                .sendKeys("Florida")
                .sendKeys(Keys.TAB)
                .sendKeys("Miami")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .sendKeys("+1 408 408 1905")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
        Thread.sleep(1000);

        //15. Click 'Continue' button
        WebElement contiuneButton =driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        action.click(contiuneButton).perform();

        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());
        Thread.sleep(1000);

        //17. Click 'Delete Account' button
        WebElement deleteButton =driver.findElement(By.cssSelector("a[href='/delete_account']"));
        action.click(deleteButton).perform();

        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(3000);

    }

}










