package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AlertTesting {
    WebDriver chrome;
    WebDriverWait wait;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("http://the-internet.herokuapp.com/javascript_alerts");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void alert1() {
        chrome.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
        String firstAlertText= chrome.switchTo().alert().getText();
        System.out.println(firstAlertText);
        chrome.switchTo().alert().accept();

    }

    @Test
    public void alert2() {
        chrome.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
        String secondAlertText= chrome.switchTo().alert().getText();
        System.out.println(secondAlertText);
        chrome.switchTo().alert().dismiss();

    }
    @Test
    public void alert3() {
        chrome.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
        String thirdAlertText= chrome.switchTo().alert().getText();
        System.out.println(thirdAlertText);
        String enterText = "Batch9";
        chrome.switchTo().alert().sendKeys(enterText);
        chrome.switchTo().alert().accept();

        String actualTextRetrieved = chrome.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        if (actualTextRetrieved.contains(enterText)) {
            System.out.println("Prompt Took the text successfully and displayed it on the page");
        }

    }

}
