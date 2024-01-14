package Selenium.Junit.Dropdown;

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
import java.util.List;

public class DropDownMenuOptionExample {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown(){
        //driver.quit();
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDownListesi = driver.findElement(By.xpath("//select[@id='dropdown']']"));
        Select select = new Select(dropDownListesi);
        select.selectByIndex(1);
        Assert.assertEquals("Options 1",select.getFirstSelectedOption().getText());
        select.selectByIndex(2);
        Assert.assertEquals("Options 2",select.getFirstSelectedOption().getText());
        List<WebElement> optionList = select.getOptions();

        int actualOptionSayisi = optionList.size();
        int expectedOptionSayisi = 3;

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

    }








}
