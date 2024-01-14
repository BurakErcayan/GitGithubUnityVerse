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

public class CheckBox01 {
    //check box örnegi
    //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox


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


    //TEST
    //1. https://the-internet.herokuapp.com/checkboxes web sitesine gidiniz.
    //2. checkbox1 ve checkbox2 yi locate ediniz.
    //3. checkbox1 in secili olmadığını kontrol ediniz.
    //4. checkbox2 nin seçili olduğnu kontrol ediniz.
    //5. checkbox1 i seçiniz
    //6. checkbox2 ye tıklayınız.
    //7. checkbox1 in seçili olduğunu assert ediniz.
    //8. checkbox2 nin seçili olmadığını assert ediniz.


    @Test
    public void checkboxTest() throws InterruptedException {
        //1.
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //2.
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //3.
        Assert.assertFalse(checkbox1.isSelected());
        //4.
        Assert.assertTrue(checkbox2.isSelected());
        //5.
        Thread.sleep(2000);
        checkbox1.click();
        //6.
        Thread.sleep(2000);
        checkbox2.click();
        Thread.sleep(2000);
        //7.
        Assert.assertTrue(checkbox1.isSelected());
        //8.
        Assert.assertFalse(checkbox2.isSelected());
    }
}
