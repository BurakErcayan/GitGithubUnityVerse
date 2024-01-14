package mondayExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class testCase02 {

   WebDriver driver;

    @Before
    public void SetUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void TearDown() throws InterruptedException {
        Thread.sleep(1500);
        //driver.close();

    }

    @Test
    public void TrendyolTest01() throws InterruptedException {

        //Test Case 1
        //1."https://www.trendyol.com.tr" web sitesine git
        //2.Mouse mızı Anne ve Çocuk sekmesi üzerine bekletelim
        //3.Alt sekmelerinden Bebek Bakımı içerisinden "Bebek Şampuanını" seçelim
        //4.Marka sekmesi altında "Nivea Baby" markasını seçelim
        //5."Fiyat" kısmına tıklayalım
        //6.Açılan alt sekmede "400 TL - 500 TL" yi seçelim



        //1."https://www.trendyol.com.tr" web sitesine git
        driver.get("https://www.trendyol.com/");


        driver.findElement(By.xpath("//button[text()='KABUL ET']")).click();

        //2.Mouse mızı Anne ve Çocuk sekmesi üzerine getirelim
        WebElement AnneveCocuk = driver.findElement(By.xpath("//a[text()='Anne & Çocuk']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(AnneveCocuk).perform();
        Thread.sleep(5000);

        //3.Alt sekmelerinden Bebek Bakımı içerisinden "Bebek Şampuanını" tıklayalım
        driver.findElement(By.xpath("//a[contains(text(),'Bebek Şampuanı')]")).click();
        Thread.sleep(3000);

        //4.Marka sekmesi altında "Nivea Baby" markasını aratalım ve seçelim
        driver.findElement(By.cssSelector("input[placeholder='Marka ara']")).
                sendKeys("Nivea Baby");
        driver.findElement(By.xpath("(//a[@class='fltr-item-wrppr'])[2]//div[@class='chckbox']")).click();
        Thread.sleep(3000);

        //5."Fiyat" kısmına tıklayalım
        WebElement Fiyat = driver.findElement(By.xpath("//div[@class='aggrgtn-cntnr-wrppr']/div[4]/div[1]"));
        Fiyat.click();
        Thread.sleep(3000);

        //6.Açılan alt sekmede "400 TL - 500 TL" yi seçelim
        WebElement FiyatAraligi =driver.findElement(By.xpath("//a/div[starts-with(text(),'450 TL - 600 TL')]/parent::a/div[1]"));
        FiyatAraligi.click();
        Thread.sleep(5000);

    }
}
