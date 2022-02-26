package day7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PhpTravelsTest {
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
//    @Ignore
//    @After
//    public void closeAfterTest() throws InterruptedException {
//        Thread.sleep(4000);
//        driver.close();
//    }

    @Test
    public void verifyingAddFund() {
        String email = "agent@phptravels.com";
        String password = "demoagent";

        //Before swith window
        //login link
        driver.findElement(By.xpath("//*[@id=\"Main\"]/section[1]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/a")).click();
        //Switch page
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);
        //input email
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(email);
        //input password
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();
        //Click on Add Fund
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();
        //Click on Bank Transfter
        driver.findElement(By.xpath("//*[@id=\"gateway_bank-transfer\"]")).click();
        //Verify is select the right bank
        WebElement radioCheck = driver.findElement(By.xpath("//*[@id=\"gateway_bank-transfer\"]"));
        Assert.assertTrue(radioCheck.isSelected());
        System.out.println("Bank Transfer is selected");
        //Pay now
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")).click();
        //Back to invoice
        driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
        //Select Yes
        driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();

        String title = driver.getTitle();
        String expectedTitle = "Add Funds - PHPTRAVELS";
        if (title.equals(expectedTitle)) {
            System.out.println("You are Back on Add Funds page");
        } else {
            System.out.println("failed");
        }

        //log out
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a")).click();

    }
}
