package day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AmazonFindItem {
    WebDriver chrome;

    @Before
    public void beforeMethod() {
        //Open the browser
        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        //Enter the URL “http://practice.automationtesting.in/”
        chrome.get("https://www.amazon.com/");
    }

    @Test
    public void test1() {
        chrome.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone", Keys.ENTER);

        List<WebElement> searchResults = chrome
                .findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div"));

//        for(WebElement eachItem:searchResults) {
//        String text =    eachItem.getText();
//        System.out.println("---------------------------\n"+ text + "---------------------------\n");
//        }

        /// //*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[9]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]

        for (int i = 8; i < searchResults.size(); i++) {

            WebElement eachPrice = chrome
                    .findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[" + i
                            + "]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]/span[2]/span[2]"));

            System.out.println(eachPrice.getText());

            if (Integer.parseInt(eachPrice.getText()) <= 150) {
                eachPrice.click();
            }

        }

    }
}
