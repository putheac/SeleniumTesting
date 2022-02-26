package day6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class AssertionsTest {
    WebDriver driver;

    @Before
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void assertFalseTest() {
        WebElement checkBox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        //Assert false--> trues
        Assert.assertFalse(checkBox1.isSelected());
        System.out.println("True");

        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        //Assert true--> failed
        Assert.assertFalse(checkBox2.isSelected());
        System.out.println("Hello");
    }

    @Test
    public void assertTrueTest() {
        WebElement checkBox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(checkBox2.isSelected());
        System.out.println("Hello");
    }

    @Test
    public void assertEqualTest() {
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();

        String expectedTitle = "Checkboxess";
        Assert.assertEquals(actualTitle,expectedTitle);
        System.out.println("assertEquals is trues");
    }

}
