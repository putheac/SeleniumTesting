package day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class ImplicitWait {

    WebDriver chrome;
    WebDriverWait wait;

    @Before
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test1() {
        chrome.findElement(By.id("txtUsername")).sendKeys("Admin");
        chrome.findElement(By.id("txtPassword")).sendKeys("admin123");
        chrome.findElement(By.id("btnLogin")).click();
        //initiating explicit wait object
        wait = new WebDriverWait(chrome, 30);
        //wait for the element to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Welcome")));

        //after visibility is true, then store the element text for verification
        String actualWelcomeText = chrome.findElement(By.id("welcome")).getText();
        String expected = "Welcome Paul";

        if (actualWelcomeText.equalsIgnoreCase(expected)) {
            System.out.println("PASSED");
        } else {
            System.out.println("GO LEARN JAVA");
        }

        //http://automationpractice.com/index.php

    }
    @Ignore
    @Test
    public void fluentWaitTest() {
        Wait wait = new FluentWait(chrome)
                .withTimeout(30,TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(Exception.class);

        wait.until(ExpectedConditions.alertIsPresent());
    }
}

