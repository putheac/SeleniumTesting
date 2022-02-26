package day8;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.PropertiesReader;

import java.util.concurrent.TimeUnit;

public class PropertiesClass {
    WebDriver driver;
    private String url = PropertiesReader.getProperty("url");
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
    }

}
