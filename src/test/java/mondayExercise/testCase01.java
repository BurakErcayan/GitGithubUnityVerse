package mondayExercise;

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

public class testCase01 {
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
    public void savonaModaExerciseTest() throws InterruptedException {

        //Test Case 1: Register User
        //1. Launch browser
        //2. Navigate to url 'https://savonamoda.com'
        //3. Verify that SAVONA is visible successfully
        //4. Click on the 'sign up button under the My Account tab at the bottom of the page'.
        //5. Verify 'Sign up!' is visible
        //6. Enter first name, last name email address and Password
        //7. click the confirmation text
        //8. Verify that 'Create Account' is visible
        //9. Click the 'Create Account'
        //10.Click 'search button'
        //11.Enter a Product Name in the Search Box
        //12.Verify that the Recently Added text is Visible
        //13.Click on the first product from the results found
        //14.verify the product name on the page that opens
        //15.click size m
        //16.delete the number of product andreplace it with '3'
        //17.click the add to cart button
        //18.click go to cart on the screen that opens
        //19.click on my account tab
        //20.Click on the 'sign out' button of your name information

        //1. Launch browser, 2. Navigate to url 'https://savonamoda.com'
        driver.get("https://savonamoda.com");

        //3. Verify that SAVONA is visible Successfully
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='logo relative']")).isDisplayed());
        Thread.sleep(1500);

        //4. Click on the 'sign up button under the My Account tab at the bottom of the page'.
        driver.findElement(By.xpath("//ul[@class='footer-links']//a[contains(text(),'Kayıt Ol')]")).click();
        Thread.sleep(1500);

        //5. Verify 'Sign up!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='register ']")).isDisplayed());
        Thread.sleep(1500);

        //6. Enter first name, last name email address and Password
        WebElement isimGirisi = driver.findElement(By.xpath("//div[contains(text(),'Ad')]/parent::*//input"));
        isimGirisi.sendKeys("Burak");
        Thread.sleep(1500);

        WebElement soyisimGiris =driver.findElement(By.xpath("//div[contains(text(),'Soyad')]/parent::*//input"));
        soyisimGiris.sendKeys("Erçayan");
        Thread.sleep(1500);

        WebElement mailGirisi = driver.findElement(By.xpath("//div[contains(text(),'Email')]/parent::*//input"));
        mailGirisi.sendKeys("burakercayanadfgh@gmail.com");
        Thread.sleep(1500);

        WebElement sifreGiris = driver.findElement(By.xpath("//div[contains(text(),'Şifre')]/parent::*//input"));
        sifreGiris.sendKeys("123456");
        Thread.sleep(1500);

        //7. click the confirmation text
        WebElement onayMetni = driver.findElement(By.cssSelector(".option-checkbox.cursor-pointer.flex-none.mt-1"));
        onayMetni.click();
        Thread.sleep(3000);

        //8. Verify that 'Create Account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Hesap Oluştur')]")).isDisplayed());

        //9. Click the 'Create Account'
        driver.findElement(By.xpath("//span[contains(text(),'Hesap Oluştur')]")).click();

        //10.Click 'search button'
        driver.findElement(By.xpath("//li[@class='flex items-center']/*")).click();
        Thread.sleep(1000);

        //11.Enter a Product Name in the Search Box
        WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Ne aramıştınız?']"));
        searchBox.sendKeys("Pantolon");
        Thread.sleep(2000);


        //12.Verify that the Recently Added text is Visible
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Son eklenen')]")).isDisplayed());

        //13.Click on the 4. product from the results found
        driver.findElement(By.xpath("//h5[contains(text(),'GOFRE PANTOLON GÖMLEK İKİLİ TAKIM - Pembe')]//ancestor::div[@data-id]")).click();
        Thread.sleep(1000);

        //14.verify the product name on the page that opens
        Assert.assertTrue(driver.findElement(By.cssSelector("div[class='product-name-main'] h2")).isDisplayed());

        //15.click size m
        driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
        Thread.sleep(1000);

        //16.delete the number of product andreplace it with '3'
        Assert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed());
        Thread.sleep(1000);

        //17.click the add to cart button
        driver.findElement(By.cssSelector("a[href='/delete_account']")).click();
        Thread.sleep(1000);

        //18.click go to cart on the screen that opens
        Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
        Thread.sleep(3000);


        //19.click on my account tab





        //20.Click on the 'sign out' button of your name information





    }

}








