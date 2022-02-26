package homeworks.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckOutVerification {
    /*
    1. go to http://automationpractice.com/index.php
    2. click on DRESSES button
    3. add items on sale to cart and checkout
    4. continue to checkout until you see the 'authentication' page and verify it
    */

    WebDriver driver;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void test1() throws InterruptedException {

        Thread.sleep(4000);
        List<WebElement> menu = driver.findElements(By.xpath("//*[@id=\"block_top_menu\"]/ul/li"));

        for (WebElement menus : menu) {
            if ((menus.getText()).contains("DRESSES")) {
                menus.click();
            }

        }

        Thread.sleep(4000);
        //This will scroll until the element is in view:
        // Create instance of Javascript executor

        WebElement element = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[3]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.perform();

        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
//        for (WebElement product : products) {
        for (int i = 1; i <= products.size(); i++) {
           WebElement priceList = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[2]/div[1]/span"));
//            List<WebElement> priceList = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[2]/div[1]"));
            System.out.println(priceList.getText());
        }
    }
}
