package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitTestingExample {

@Before
    public void setUp() {
//        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.techcircleschool.com");
    System.out.println("Openning Browser");
    }
@After
    public void tearDown() {
        System.out.println("Closing Brower");
    }

@Test
    public void test1() {
        System.out.println("Test1");
    }
@Test
    public void test2() {
        System.out.println("Test2");
    }
}
