package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SelectTest {
    WebDriver chrome;
    WebDriverWait wait;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/dropdown");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws InterruptedException {
        WebElement staticDropdown = chrome.findElement(By.id("dropdown"));
        Select select = new Select(staticDropdown);

        Thread.sleep(2000);
        select.selectByIndex(1);

        Thread.sleep(3000);
        select.selectByValue("2");
        Thread.sleep(3000);
        select.selectByVisibleText("Option 1");
    }
}
