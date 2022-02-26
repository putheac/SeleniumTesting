package saturdayreview.week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class DemoGuru99Register {
    WebDriver driver;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void testRegister() throws Exception {
        WebElement selectCountries = driver.findElement(By.xpath("//select[@name='country']"));
        Select selectUS = new Select(selectCountries);


        //First Name
        driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("John");
        //Last Name
        driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys("Mark");
        //Phone
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("1234567890");
        //Email
        driver.findElement(By.id("userName")).sendKeys("mark@gmail.com");
        //Address
        driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("7400 Electra Ct");
        //City
        driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Gaithersburg");
        //State
        driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Maryland(MD)");
        //Postal Code
        driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("20879");
        //Country
        selectUS.selectByValue("UNITED STATES");
        //Username
        driver.findElement(By.id("email")).sendKeys("mark99");
        //Password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mark9933");
        //ConFirm Password
        driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys("mark9933");
        //just to check if imformation is good
        Thread.sleep(3000);
        //Submit
        driver.findElement(By.xpath("//input[@type='submit']")).click();


    }

}
