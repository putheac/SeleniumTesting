package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenAndVerifyTitle {
    WebDriver driver;

    @Before
    public void beforeTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();
    }
    @After
    public void afterTest() {
        driver.close();;
    }

    @Ignore
    @Test
    public void verifyTitle() {
        String actualUrl = driver.getCurrentUrl();
        String actualPageTitle = driver.getTitle();

        String expectedUrl = "https://www.youtube.com/";
        String expectedPageTitle = "YouTube";

        if (expectedUrl.equalsIgnoreCase(actualUrl)) {
            System.out.println("URL matched and Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected to see--> " + expectedUrl);
            System.out.println("The Driver got --> " + actualUrl);
        }

        if (expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
            System.out.println("Title matched and Passed");
        } else {
            System.out.println("Failed");
            System.out.println("Expected to see--> " + expectedPageTitle);
            System.out.println("The Driver got --> " + actualPageTitle);
        }

    }

    @Ignore
    @Test
    public void verifyURL() {
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.youtube.com/";
        if (expectedUrl.equalsIgnoreCase(actualUrl)) {
            System.out.println("URL matched and Passed");
        } else {
            System.out.println("FAILED");
            System.out.println("Expected to see--> " + expectedUrl);
            System.out.println("The Driver got --> " + actualUrl);
        }
    }

    @Test
    public void pageSourcePrint() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        driver.navigate().to("https://www.techcircleschool.com/");
        driver.navigate().back(); // navigate back to youtube.com
    }



}


