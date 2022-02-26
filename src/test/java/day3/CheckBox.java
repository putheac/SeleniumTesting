package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBox {

    WebDriver chrome;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        chrome= new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/");
        chrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @Test
    public void testCheckBox1() {

        chrome.findElement(By.xpath("//div[@id='content']/ul/li[6]/a")).click();

        WebElement firstCheckBox = chrome.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
        WebElement secondCheckBox = chrome.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        Boolean firstCheckBoxSelected = firstCheckBox.isSelected();
        Boolean secondCheckBoxSelected = secondCheckBox.isSelected();

        if (firstCheckBoxSelected) {
            System.out.println("CheckBok1 is alreay selected");
        } else {
            firstCheckBox.click();

        }
        if (secondCheckBoxSelected) {
            System.out.println("CheckBok2 is alreay selected");
        } else {
            secondCheckBox.click();

        }
    }
}
