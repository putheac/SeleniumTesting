package saturdayreview.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.OrderWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Instant;

/*
1. Go to Amazon
2. Send "any key"
3. click search
4. select one of the item
5. add it to cart
6. validate the item in the cart
7. remove the item
8. validate the cart is empty
9. navigate to youtube
10. validate the title is youtube
11. search video
12. play the video.
* */

public class AmazonTesting {
    WebDriver chrome;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("https://www.amazon.com/");
        //chrome.manage().window().maximize();

    }


    @Test
    public void asearch() throws InterruptedException {
        chrome.findElement(By.id("twotabsearchtextbox")).sendKeys("sun glass");
        chrome.findElement(By.id("nav-search-submit-button")).click();
        //select item
        chrome.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div")).click();
        //Add item
        chrome.findElement(By.id("add-to-cart-button")).click();
        //go to cart
        chrome.findElement(By.xpath("//*[@id=\"nav-cart\"]")).click();
        //delete item
        WebElement e = chrome.findElement(By.xpath("//input[@value='Delete']"));
        e.click();
        //go to youtube
        chrome.navigate().to("https://www.youtube.com/");
        Thread.sleep(2000);
        //Check page URL and expect URL
        String actualPageTitle = chrome.getTitle();
        String expectedPageTitle = "YouTube";
        if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
            System.out.println("Title matched and Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected to see--> " + expectedPageTitle);
            System.out.println("The Driver got --> " + actualPageTitle);
        }

        //Enter text into search box
        chrome.findElement(By.name("search_query")).sendKeys("java is awesome");
        //Click Search Button
        chrome.findElement(By.id("search-icon-legacy")).click();
        Thread.sleep(2000);
        //Play video
        chrome.findElement(By.linkText("Why Should You Learn Java?")).click();
        //chrome.findElement(By.xpath("//*[@id=\"video-title\"]/yt-formatted-string")).click();
        Thread.sleep(9000);
        //chrome.close();

    }

}
