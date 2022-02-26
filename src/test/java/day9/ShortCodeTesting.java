package day9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.PropertiesReader;

import static utilities.Driver.driver;

public class ShortCodeTesting {
    WebDriverWait wait;
    @Before
    public void setUp() {
        Driver.getDriver();

    }

    @Test
    public void test() {
        driver.findElement(By.id("userId")).sendKeys(PropertiesReader.getProperty("userID"));
        driver.findElement(By.id("password")).sendKeys(PropertiesReader.getProperty("passwords"));
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click on Find a Short Code
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Actions action = new Actions(driver);

        driver.switchTo().frame(driver.findElement(By.xpath("//html/body/div[1]/div[11]/div[1]/div[2]/div[1]/div/span/iframe")));
        WebElement fb = driver.findElement(By.xpath("//li[@class='nav-link']"));//fb Like button

        Actions builder = new Actions(driver);
        builder.moveToElement(fb).click().build().perform();
        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
       driver.findElement(By.xpath("//li[@class='nav-link']")).click();

    }
//    @After
//    public void tearDown() {
//        Driver.tearDown();
//    }
}
