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
import java.util.Set;

public class deneme1 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {

        //hepsiburada.com sitesine gidiniz.
        //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
        //Sıralamalardan çok satanlara tıkla
        //marka olarak Apple markasını seç
        //İlk çıkan ürüne git
        //ilk çıkan ürüne gittikten sonra ek hizmet ekleye tıkla
        //ürünü sepete ekle
        //sepete git ve sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.
        //Sepete Git butonuna tıkla
        //Sepetteki ürünün para birimi değerini consolda yazdır
        //Browser ı kapat.

        driver.get("https://www.hepsiburada.com/");
        String ilksayfam = driver.getWindowHandle();

        WebElement ElektronikButonu = driver.findElement(By.xpath("(//span[@class='sf-MenuItems-UHHCg2qrE5_YBqDV_7AC'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(ElektronikButonu).perform();
        Thread.sleep(3000);
        WebElement bilgisayarButonu = driver.findElement(By.xpath("//a[text()='Bilgisayar/Tablet']"));
        Thread.sleep(3000);
        // TEXT İLE LACATOR ALMA
        actions.moveToElement(bilgisayarButonu).perform();
        WebElement dizüstübilgisayarButonu = driver.findElement(By.xpath("//a[text()='Dizüstü Bilgisayar']"));
        Thread.sleep(3000);
        dizüstübilgisayarButonu.click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[text()='Kabul et']")).click();
        Thread.sleep(2000);
        // Banner Tıklama
        driver.findElement(By.xpath("//div[@class='categoryBanner']//img[@title='windowslu_laptoplar']")).click();
        //marka olarak asus markasını seç
        driver.findElement(By.xpath("//div[text()='Asus']")).click();
        Thread.sleep(3000);
        // İlk çıkan ürüne git
        Set<String> TumPencereler = driver.getWindowHandles();
        for (String handle : TumPencereler) {
            if (!handle.equals(ilksayfam)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        //ilk çıkan ürüne gittikten sonra ek hizmet sigortaya tıkla
        driver.findElement(By.xpath("//*[text()='Ekle']")).click();
        Thread.sleep(3000);
        //daha sonra ürünü sepete ekle
        driver.findElement(By.xpath("//button[@id='addToCart']")).click();
        Thread.sleep(3000);
        //sepete git sepete gittikten sonra sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.
        driver.findElement(By.xpath("//div[@class='sf-reco-cXJJFj eDFt sbgcse06alz']")).click();


    }
}