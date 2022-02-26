package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class IframesTest {
    WebDriver driver;
    private String url="https://jqueryui.com/droppable/";
    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void closeAfterTest() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }
    @Test
    public void dragAndDropTest() throws InterruptedException {
        Actions action = new Actions(driver);

        driver.switchTo().frame(0);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        action.dragAndDrop(drag, drop).build().perform();


        //navigate back
        Thread.sleep(3000);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[@id=\"logo-events\"]/h2/a")).click();
    }
}
