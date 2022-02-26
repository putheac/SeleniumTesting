package day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase1 {
    /*
    1) Open the browser
    2) Enter the URL “http://practice.automationtesting.in/”
    3) Click on Shop Menu
    4) Now click on Home menu button
    5) Test whether the Home page has Three Sliders only
    6) The Home page must contains only three sliders
    */

    WebDriver chrome;

    @Before
    public void beforeMethod() {
        //Open the browser
       WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        //Enter the URL “http://practice.automationtesting.in/”
        chrome.get("http://practice.automationtesting.in/");
    }

    @Test
    public void test1() {
        //Click on shop Menu
        chrome.findElement(By.xpath("//li[@id=\"menu-item-40\"]")).click();
        //Click on Home Menu
        chrome.findElement(By.xpath("//div[@id=\"content\"]/nav/a")).click();
        //Test whether the Home page has Three Sliders only

    }


}
