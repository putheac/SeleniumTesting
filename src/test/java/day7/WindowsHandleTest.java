package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowsHandleTest {
    WebDriver driver;
    private String url="https://phptravels.com/demo";
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
    public void loginAgentFrontPage() throws InterruptedException {
        String email = "agent@phptravels.com";
        String password = "demoagent";

        //Before switch window
        //login link
        driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();
        System.out.println("Before Switching window");
        System.out.println(driver.getTitle());

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(email);
        System.out.println("After Switching");
        System.out.println(driver.getTitle());

        //Switch back to former window
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.switchTo().window(parentID);


    }


}
