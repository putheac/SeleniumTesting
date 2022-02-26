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

import java.util.List;
import java.util.concurrent.TimeUnit;

public class dynamicDropDown {
    WebDriver chrome;
    WebDriverWait wait;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("https://www.makemytrip.com/");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait= new WebDriverWait(chrome,5);
    }

    @Test
    public void test1() throws InterruptedException {
        wait();
        chrome.findElement(By.id("root")).click();
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chrome.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div/div/div/div[1]/label/input")).click();
        //From
        wait();
        chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("iad");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chrome.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]")).click();
        // To
        wait();
        //chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).click();
        chrome.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("pnh");
        wait();
        chrome.findElement(By.className("calc60")).click();
        //chrome.findElement(By.xpath("//*[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();

//        chrome.findElement(By.xpath(".//*[@id='accountSelectContainer']/span/a/span[1]")).click();
//        List<WebElement> options = chrome.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
//        for (WebElement option : options) {
//            if(testData.equals(option.getText()))
//                option.click();

    }
}

