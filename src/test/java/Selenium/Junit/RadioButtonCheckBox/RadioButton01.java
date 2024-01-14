package Selenium.Junit.RadioButtonCheckBox;

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

public class RadioButton01 {

    //radio button
    //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_radio


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

    //TEST
    //1. https://formy-project.herokuapp.com/radiobutton web sitesine gidiniz.
    //2. rb1 , rb2 ve rb3 ü locate ediniz.
    //3. rb1 in seçili olduğunu kontrol ediniz.
    //4. rb2 nin seçili olmadığını kontrol ediniz.
    //5. rb3 nin seçili olmadığını kontrol ediniz.
    //6. rb3 e tıklayınız.
    //7. rb1 in seçili olmadığını kontrol ediniz.
    //8. rb3 ün seçili olduğunu kontrol ediniz.

    @Test
    public void radioButtonTest() throws InterruptedException {
        //1.
        driver.get("https://formy-project.herokuapp.com/radiobutton");


        //2.
        WebElement rb1 = driver.findElement(By.xpath("//input[@value='option1']"));
        WebElement rb2 = driver.findElement(By.xpath("//input[@value='option2']"));
        WebElement rb3 = driver.findElement(By.xpath("//input[@value='option3']"));


        //3.
        //beklenen seçili olması isSelected seçili ise true doner
        Assert.assertTrue(rb1.isSelected());
        System.out.println(rb1.isSelected());
        //4.
        Assert.assertFalse(rb2.isSelected());
        System.out.println(rb2.isSelected());
        //5.
        Assert.assertFalse(rb3.isSelected());
        System.out.println(rb3.isSelected());
        //6.
        Thread.sleep(2000);
        rb3.click();
        Thread.sleep(2000);
        //7.
        Assert.assertFalse(rb1.isSelected());
        System.out.println(rb1.isSelected());
        //8.
        Assert.assertTrue(rb3.isSelected());
        System.out.println(rb3.isSelected());
        Thread.sleep(2000);
        System.out.println("Tebrikler Testiniz Basariyla Tamamlandı.!!!");


    }

}
