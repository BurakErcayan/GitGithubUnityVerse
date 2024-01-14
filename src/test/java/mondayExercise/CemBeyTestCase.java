package mondayExercise;

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

import java.time.Duration;

public class CemBeyTestCase {

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
    public void demoWebShop() throws InterruptedException {


        // url: http://demowebshop.tricentis.com/
        // ➢ Bu projeyi Java ve Selenium kütüphanesini kullanarak test edeceksiniz
        // ➢ Action class kullanılacak


        //  Test Senaryoları
        //  Senaryo 1: Kayıt oluşturma Testi


        //➢ Siteye gidin
        //➢ Register butonuna tıklayın
        //➢ Kişisel bilgileri doldurun ve register butonuna tıklayın
        //➢ Başarılı bir şekilde kaydolduğunuzu doğrulayınız



        //   Senaryo 4: Negatif Login Test
        //➢ Siteye gidin
        //➢ Login butonuna tıklayın
        //➢ Geçersiz email veya password giriniz
        //➢ Login butonuna tıklatınız ve login olamadığınızı doğrulayınız


        //  Senaryo 5: Order Test
        //➢ Siteye gidin
        //➢ Login olun
        //➢ Computers>Notebook un altında “14.1-inch Laptop” adli ürüne tıklatınız
        //➢ Ad to Cart butonuna tıklatınız ve urunun başarılı bir şekilde eklendiğini doğrulayın
        //➢ Shopping cart butonuna tıklatıp sepetinize gidin ve urunun orda görüldüğünü doğrulayın
        //➢ Agree check box tıklatıp Sartları Kabul edin
        //➢ Checkout butonuna tıklatın
        //➢ Açılan sayfada tüm bilgileri doldurun ve confirm order butonuna tıklatın
        //➢ “Your order has been successfully processed!” mesajının görüldüğünü doğrulayın

    //   driver.get("http://demowebshop.tricentis.com");
       Actions actions=new Actions(driver);
    //   WebElement registerButton = driver.findElement(By.xpath("//a[text()='Register']"));
    //   actions.click(registerButton).perform();
    //   WebElement genderButton=driver.findElement(By.xpath("//input[@id='gender-male']"));
    //   actions.click(genderButton)
    //           .sendKeys(Keys.TAB)
    //           .sendKeys("Burak")
    //           .sendKeys(Keys.TAB)
    //           .sendKeys("Erçayan")
    //           .sendKeys(Keys.TAB)
    //           .sendKeys("burakercayan6@gmail.com")
    //           .sendKeys(Keys.TAB)
    //           .sendKeys("123456789")
    //           .sendKeys(Keys.TAB)
    //           .sendKeys("123456789")
    //           .sendKeys(Keys.TAB)
    //           .sendKeys(Keys.ENTER)
    //           .perform();
    //   Thread.sleep(3000);
    //Assert.assertTrue((driver.findElement(By.xpath("//div[@class='result']")).isDisplayed()));

        //   Senaryo 2: Negatif kayıt Testi
        //➢ Siteye gidin
        //➢ Register butonuna tıklayın
        //➢ Yukarda kaydolduğunuz email ile kaydolmaya calisin
        //➢ Register butonuna tıkayınız
        //➢ “The specified email already exists” mesajının görüldüğünü doğrulayınız

       //driver.get("http://demowebshop.tricentis.com");
       //WebElement registerButton1 = driver.findElement(By.xpath("//a[text()='Register']"));
       //actions.click(registerButton1).perform();
       //WebElement genderButton1=driver.findElement(By.xpath("//input[@id='gender-male']"));
       //actions.click(genderButton1)
       //        .sendKeys(Keys.TAB)
       //        .sendKeys("Burak")
       //        .sendKeys(Keys.TAB)
       //        .sendKeys("Erçayan")
       //        .sendKeys(Keys.TAB)
       //        .sendKeys("burakercayan6@gmail.com")
       //        .sendKeys(Keys.TAB)
       //        .sendKeys("123456789")
       //        .sendKeys(Keys.TAB)
       //        .sendKeys("123456789")
       //        .sendKeys(Keys.TAB)
       //        .sendKeys(Keys.ENTER)
       //        .perform();
       //        Thread.sleep(3000);
       //        Assert.assertTrue(driver.findElement(By.xpath("//li[text()='The specified email already exists']")).isDisplayed());

        //  Senaryo 3: Login Test
        //➢ Siteye gidin
        //➢ Login butonuna tıklayın
        //➢ Geçerli email ve password I giriniz
        //➢ Login butonuna tıklatınız ve login olduğunuzu doğrulayınız

      // driver.get("http://demowebshop.tricentis.com");
      // WebElement sinUpButton=driver.findElement(By.xpath("//a[text()='Log in']"));
      // actions.click(sinUpButton).perform();
      // WebElement emailButton=driver.findElement(By.xpath("//input[@class='email']"));
      // actions.click(emailButton)
      //         .sendKeys("burakercayan6@gmail.com")
      //         .sendKeys(Keys.TAB)
      //         .sendKeys("123456789")
      //         .sendKeys(Keys.TAB)
      //         .sendKeys(Keys.TAB)
      //         .sendKeys(Keys.TAB)
      //         .sendKeys(Keys.ENTER).perform();

        //   Senaryo 4: Negatif Login Test
        //➢ Siteye gidin
        //➢ Login butonuna tıklayın
        //➢ Geçersiz email veya password giriniz
        //➢ Login butonuna tıklatınız ve login olamadığınızı doğrulayınız

        driver.get("http://demowebshop.tricentis.com");
        WebElement sinUpButton1=driver.findElement(By.xpath("//a[text()='Log in']"));
        actions.click(sinUpButton1).perform();
        WebElement emailButton1=driver.findElement(By.xpath("//input[@class='email']"));
        actions.click(emailButton1)
                .sendKeys("burakercayan68@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("123456789")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

            Assert.assertTrue(driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).isDisplayed());

        //  Senaryo 5: Order Test
        //➢ Siteye gidin
        //➢ Login olun
        //➢ Computers>Notebook un altında “14.1-inch Laptop” adli ürüne tıklatınız
        //➢ Ad to Cart butonuna tıklatınız ve urunun başarılı bir şekilde eklendiğini doğrulayın
        //➢ Shopping cart butonuna tıklatıp sepetinize gidin ve urunun orda görüldüğünü doğrulayın
        //➢ Agree check box tıklatıp Sartları Kabul edin
        //➢ Checkout butonuna tıklatın
        //➢ Açılan sayfada tüm bilgileri doldurun ve confirm order butonuna tıklatın
        //➢ “Your order has been successfully processed!” mesajının görüldüğünü doğrulayın

    }
}
