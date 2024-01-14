package Selenium.Junit.AutomationExercise01;

import com.github.dockerjava.api.model.Driver;
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

public class TC06 {

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

        // Test Case 6: Register User
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        // 3. Verify that home page is visible successfully
        // 4. Click on 'Contact Us' button
        // 5. Verify 'GET IN TOUCH' is visible
        // 6. Enter name, email, subject and message
        // 7. Upload file
        // 8. Click 'Submit' button
        // 9. Click OK button
        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        // 11. Click 'Home' button and verify that landed to home page successfully

        //1. Launch browser, 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
        Thread.sleep(1500);

        //4. Click on 'Contact Us' button
        driver.findElement(By.cssSelector("a[href='/contact_us']")).click();

        // 5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Get In Touch']")).isDisplayed());


        // 6. Enter name, email, subject and message
        WebElement isim = driver.findElement(By.cssSelector("input[placeholder='Name']"));
        isim.sendKeys("burak");
        WebElement mail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        mail.sendKeys("burakercayan@gmail.com");
        WebElement konuBaslik = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
        konuBaslik.sendKeys("Test Case");
        WebElement mesajicerigi = driver.findElement(By.xpath("//textarea[@id='message']"));
        mesajicerigi.sendKeys("Test Caselerde Verilen İlk Test Kullanıcıyı Sildiginden Diger Testlerde" +
                "Yeniden Kullanıcı Olusturmak Zorundayız. ");
        Thread.sleep(2000);

        // 7. Upload file
        WebElement dosyaYukle = driver.findElement(By.cssSelector("input[name='upload_file']"));
        dosyaYukle.sendKeys("C:/Users/ASUS/Documents/hata görseli.png");
        Thread.sleep(2000);

        // 8. Click 'Submit' button
        driver.findElement(By.xpath("//input[@name='submit']")).click();

        // 9. Click OK button
        driver.switchTo().alert().accept();

        // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.cssSelector(".status.alert.alert-success")).isDisplayed());

        // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.cssSelector("a[class='btn btn-success'] span")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());

    }

}
