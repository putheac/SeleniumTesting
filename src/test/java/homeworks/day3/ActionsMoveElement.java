package homeworks.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class ActionsMoveElement {
    WebDriver driver;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void test() throws InterruptedException {
        Thread.sleep(5000);
        //Actions class method drop drag and drop
        Actions builder = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement drop = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        //Perform drag and drop
        builder.clickAndHold(drag)
                .moveByOffset(-1, -1) // To fix issue with drag and drop in Chrome V61.0.3163.79
                .moveToElement(drop, drop.getLocation().getX()+drop.getSize().getWidth()/2, drop.getLocation().getY()+drop.getSize().getHeight()/2)
                .release(drop)
                .build()
                .perform();
        //builder.dragAndDrop(drag, drop).build().perform();
        //verify text changed in drop 'Drop here' box
//        String textTo = drop.getText();
//        if(textTo.equals("B")) {
//            System.out.println("PASS: File is dropped drop target as expected");
//        }else {
//            System.out.println("FAIL: File couldn't be dropped drop target as expected");
//        }
    }
}
