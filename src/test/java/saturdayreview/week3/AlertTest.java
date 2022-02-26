package saturdayreview.week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class AlertTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }
    @Test
    public void testAlerts() throws Exception {
        //Alert alert= driver.switchTo().alert();
        driver.findElement(By.id("alertButton")).click();
        String checkText =driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        String expecteText ="You clicked a button";
        if (expecteText.equalsIgnoreCase(checkText)) {
            System.out.println("2. Click Button to see alert-->> Click Successful");
        }

        //Second
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(6000);
        driver.switchTo().alert().accept();
        //Third
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        String confirmText =  driver.findElement(By.id("confirmResult")).getText();
        String expectedConfirmText = "You selected Ok";
        Thread.sleep(3000);
        if (confirmText.equalsIgnoreCase(expectedConfirmText)) {
            System.out.println("3.You selected Ok-->> is Appeared");
        } else {
            System.out.println("Failed");
        }
        // 4
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Mangoo");
        driver.switchTo().alert().accept();
        boolean ifDisplayed = driver.findElement(By.id("promptResult")).isDisplayed();
        WebElement showResult = driver.findElement(By.id("promptResult"));
        if (ifDisplayed) {
            System.out.println(showResult.getText()+" is Displayed");
        } else {
            System.out.println("Failed, no text show or Click me not Work");
        }


    }
}
