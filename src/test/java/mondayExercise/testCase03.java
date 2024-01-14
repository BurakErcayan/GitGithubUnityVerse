package mondayExercise;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class testCase03 {

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
    public void amazonTest(){

        // Test Case
        //1."https://www.amazon.com.tr/" ye gidelim.
        //2.Tüm Kategoriler kısmından "pc ve video oyunlarını" seçelim.
        //3.Arama kısmına "uncherted 4" yazalım.
        //4.Mouse mızı serch butonunun üzerine götürüp tıklayalım.
        //5.Açılan ekranda marka kısmından "SONY" yi seçelim.
        //6.Fiyat kısmından "500 TL ve Üzeri" olanı seçelim.
        //7.


        driver.get(" https://facebook.com ");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


        //Faker faker = new Faker();
        //String fakeFirstName = faker.name().nameWithMiddle();
        //String fakeEmail = faker.internet().emailAddress();
        //String fakePassword = faker.internet().password();
        //String fakeAddress = faker.address().streetAddressNumber();
        //String fakeAddress2 = faker.address().fullAddress();
        //String fakeMobilePhone = faker.phoneNumber().cellPhone();


        //p[normalize-space()='Your content goes here.']













    }












}
