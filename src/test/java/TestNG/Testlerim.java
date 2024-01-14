package TestNG;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Testlerim {

    WebDriver driver;

    @BeforeMethod
    public void SetUp(){

        driver =new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void Test01() throws InterruptedException {

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



        Faker faker = new Faker();
        String fakeFirstName = faker.name().username();
        String fakeEmail = faker.internet().emailAddress();
        String fakePassword = faker.internet().password();
        String fakeLastName = faker.name().lastName();
        String fakeCompany = faker.company().name();
        String fakeAddress = faker.address().streetAddress();
        String fakeState = faker.address().state();
        String fakeCity =faker.address().cityName();
        String fakePostCode = faker.address().zipCode();
        String fakeMobilePhone = faker.phoneNumber().cellPhone();
        System.out.println("Test01 Başlatıldı..........");

        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());

        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='New User Signup!']")).isDisplayed());

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@placeholder='Name']")).isDisplayed();
        WebElement isim = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        isim.sendKeys(fakeFirstName);
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).isDisplayed();
        WebElement mailGirisi = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        mailGirisi.sendKeys(fakeEmail);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[normalize-space()='Signup']")).click();

        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Enter Account Information']")).isDisplayed());

        //9. Fill details: Title, Name, Email, Password, Date of birth
        WebElement mr = driver.findElement(By.cssSelector("#id_gender1"));
        mr.click();
        WebElement sifreGirin = driver.findElement(By.xpath("//input[@id='password']"));
        sifreGirin.sendKeys(fakePassword);
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
        ad.sendKeys(fakeFirstName);
        WebElement soyAd = driver.findElement(By.xpath("//input[@id='last_name']"));
        soyAd.sendKeys(fakeLastName);
        WebElement sirket = driver.findElement(By.xpath("//input[@id='company']"));
        sirket.sendKeys(fakeCompany);
        WebElement adres = driver.findElement(By.xpath("//input[@id='address1']"));
        adres.sendKeys(fakeAddress);
        WebElement ulke = driver.findElement(By.xpath("//select[@id='country']"));
        Select select3 = new Select(ulke);
        select3.selectByIndex(1);
        Thread.sleep(1000);
        WebElement eyalet = driver.findElement(By.xpath("//input[@id='state']"));
        eyalet.sendKeys(fakeState);
        WebElement sehir = driver.findElement(By.xpath("//input[@id='city']"));
        sehir.sendKeys(fakeCity);
        WebElement postaKodu = driver.findElement(By.xpath("//input[@id='zipcode']"));
        postaKodu.sendKeys(fakePostCode);
        WebElement telNo = driver.findElement(By.xpath("//input[@id='mobile_number']"));
        telNo.sendKeys(fakeMobilePhone);

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();
        Thread.sleep(3000);




      //14. Verify that 'ACCOUNT CREATED!' is visible
      Assert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed());
       Thread.sleep(1000);
       //15. Click 'Continue' button
       driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();//16. Verify that 'Logged in as username' is visiblAssert.assertTrue(driver.findElement(By.xpath("//li[10]//a[1]")).isDisplayed())Thread.sleep(1000);//17. Click 'Delete Account' buttodriver.findElement(By.cssSelector("a[href='/delete_account']")).click()Thread.sleep(1000);//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' buttoAssert.assertTrue(driver.findElement(By.cssSelector("h2[class='title text-center'] b")).isDisplayed())driver.findElement(By.cssSelector(".btn.btn-primary")).click()Thread.sleep(3000)System.out.println("Test01 Başarıyla Sonlandırıldı.......");
    }


        @Test
        public void Test02() throws InterruptedException {

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
     mail.sendKeys("burakercayanadfii@gmail.com");
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

     System.out.println("Test02 Başarıyla Sonlandırıldı.......");
    }

        @Test
        public void Test03() throws InterruptedException {

     // Test Case 3: Register User
     // 1. Launch browser
     // 2. Navigate to url 'http://automationexercise.com'
     // 3. Verify that home page is visible successfully
     // 4. Click on 'Signup / Login' button
     // 5. Verify 'Login to your account' is visible
     // 6. Enter incorrect email address and password
     // 7. Click 'login' button
     // 8. Verify error 'Your email or password is incorrect!' is visible

     System.out.println("Test03 Başlatıldı..........");

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
     mail.sendKeys("burakercayanadfii@gmail.com");
     WebElement sifre = driver.findElement(By.xpath("//input[@placeholder='Password']"));
     sifre.sendKeys("1905");

     // 7. Click 'login' button
     driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

     // 8. Verify error 'Your email or password is incorrect!' is visible
     Assert.assertTrue(driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).isDisplayed());

     System.out.println("Test03 Başarıyla Sonlandırıldı.......");
    }
        @Test
        public void Test04() throws InterruptedException {

     // Test Case 4: Register User
     // 1. Launch browser
     // 2. Navigate to url 'http://automationexercise.com'
     // 3. Verify that home page is visible successfully
     // 4. Click on 'Signup / Login' button
     // 5. Verify 'Login to your account' is visible
     // 6. Enter correct email address and password
     // 7. Click 'login' button
     // 8. Verify that 'Logged in as username' is visible
     // 9. Click 'Logout' button
     // 10. Verify that user is navigated to login page

     System.out.println("Test04 Başlatıldı..........");

     // 3. Verify that home page is visible successfully
     Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/product_details/43']")).isDisplayed());
     Thread.sleep(1500);

     // 4. Click on 'Signup / Login' button
     driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();
     Thread.sleep(3000);

     // 5. Verify 'Login to your account' is visible
     Assert.assertTrue(driver.findElement(By.cssSelector("div[class='login-form'] h2")).isDisplayed());
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

     // 9. Click 'Logout' button
     driver.findElement(By.cssSelector("a[href='/logout']")).click();

     // 10. Verify that user is navigated to login page
     Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).isDisplayed());

     System.out.println("Test04 Başarıyla Sonlandırıldı.......");
    }
        @Test
        public void Test05() throws InterruptedException {

     // Test Case 5: Register User
     //1. Launch browser
     //2. Navigate to url 'http://automationexercise.com'
     //3. Verify that home page is visible successfully
     //4. Click on 'Signup / Login' button
     //5. Verify 'New User Signup!' is visible
     //6. Enter name and already registered email address
     //7. Click 'Signup' button
     //8. Verify error 'Email Address already exist!' is visible

     System.out.println("Test05 Başlatıldı..........");

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

     System.out.println("Test05 Başarıyla Sonlandırıldı.......");}
        @Test
        public void Test06() throws InterruptedException {

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

     System.out.println("Test06 Başlatıldı..........");

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

     System.out.println("Test06 Başarıyla Sonlandırıldı.......");}
        @Test
        public void Test07() throws InterruptedException {

     // Test Case 7: Register User
     // 1. Launch browser
     // 2. Navigate to url 'http://automationexercise.com'
     // 3. Verify that home page is visible successfully
     // 4. Click on 'Test Cases' button
     // 5. Verify user is navigated to test cases page successfully


     System.out.println("Test07 Başlatıldı..........");

     //3. Verify that home page is visible successfully
     Assert.assertTrue(driver.findElement(By.xpath("//a[normalize-space()='Home']")).isDisplayed());
     Thread.sleep(1500);

     // 4. Click on 'Test Cases' button
     driver.findElement(By.cssSelector("a[href='/test_cases']")).click();

     // 5. Verify user is navigated to test cases page successfully
     Assert.assertTrue(driver.findElement(By.xpath("//b[normalize-space()='Test Cases']")).isDisplayed());

     System.out.println("Test07 Başarıyla Sonlandırıldı.......");}
        @Test
        public void Test08() throws InterruptedException {

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

     System.out.println("Test08 Başlatıldı..........");

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

     System.out.println("Test08 Başarıyla Sonlandırıldı.......");}

    @AfterMethod
    public void teardown() {

        driver.quit();
    }
}




