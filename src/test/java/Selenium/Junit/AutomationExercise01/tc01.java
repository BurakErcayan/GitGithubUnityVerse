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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class tc01 {
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


        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();


        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());


        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).isDisplayed();
        WebElement isimGirisi = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        isimGirisi.sendKeys("Burak");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).isDisplayed();
        WebElement mailGirisi = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mailGirisi.sendKeys("burakercayanadfir@gmail.com");


        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();


        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement mr = driver.findElement(By.cssSelector("#id_gender1"));
        mr.click();


        WebElement sifreGirin = driver.findElement(By.xpath("//input[@id='password']"));
        sifreGirin.sendKeys("123456");


        WebElement gun= driver.findElement(By.xpath("//select[@id='days']"));
        Select select=new Select(gun);
        select.selectByIndex(22);


        WebElement ay = driver.findElement(By.xpath("//select[@id='months']"));
        Select select1 = new Select(ay);
        select1.selectByIndex(11);


        WebElement yil = driver.findElement(By.xpath("//select[@id='years']"));
        Select select2 = new Select(yil);
        select2.selectByIndex(35);


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//input[@id='newsletter']")).click();


        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//input[@id='optin']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement ad = driver.findElement(By.xpath("//input[@id='first_name']"));
        ad.sendKeys("Burak");


        WebElement soyAd = driver.findElement(By.xpath("//input[@id='last_name']"));
        soyAd.sendKeys("Ercayan");


        WebElement sirket = driver.findElement(By.xpath("//input[@id='company']"));
        sirket.sendKeys("Asel Hukuk");


        WebElement adres = driver.findElement(By.xpath("//input[@id='address1']"));
        adres.sendKeys("Halkali");


        WebElement ulke = driver.findElement(By.xpath("//select[@id='country']"));
        Select select3 = new Select(ulke);
        select3.selectByIndex(1);
        Thread.sleep(1000);

        WebElement eyalet = driver.findElement(By.xpath("//input[@id='state']"));
        eyalet.sendKeys("Florida");


        WebElement sehir = driver.findElement(By.xpath("//input[@id='city']"));
        sehir.sendKeys("Miami");


        WebElement postaKodu = driver.findElement(By.xpath("//input[@id='zipcode']"));
        postaKodu.sendKeys("123456789");


        WebElement telNo = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        telNo.sendKeys("+1 408 408 1905");


        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        Thread.sleep(1000);

        //14. Verify that 'ACCOUNT CREATED!' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
        Thread.sleep(1000);

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();


        //16. Verify that 'Logged in as username' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());
        Thread.sleep(1000);

        //17. Click 'Delete Account' button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        Thread.sleep(1000);


        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(3000);

    }
}
