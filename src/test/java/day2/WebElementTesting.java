package day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class WebElementTesting {
    WebDriver chrome;
    Select select;

    @Before
    public void beforeMethod() {

        WebDriverManager.chromedriver().setup();
        chrome = new ChromeDriver();
        chrome.get("http://demo.automationtesting.in/Index.html");
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // chrome.manage().window().maximize();
    }


    @Test
    public void registerForm() throws InterruptedException {
        chrome.findElement(By.id("email")).sendKeys("abcd@gmail.com");
        chrome.findElement(By.id("enterimg")).click();
        //first name
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Puthea");
        //Last name
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Chhean");
        //address
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("Mr James Smith Flat 7 118 Blackhorse Grove London W6 7HB UK");
        //email
        chrome.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("adbc@gmail.com");
        //phone
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("1234567890");
        //gender
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
        //hobbies
        chrome.findElement(By.id("checkbox2")).click();
        //This will scroll the web page till end.
        JavascriptExecutor js = (JavascriptExecutor) chrome;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //languages
        Thread.sleep(2000);

        chrome.findElement(By.id("msdd")).click();
        //English
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[8]")).click();
        //Dutch
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[7]/div/multi-select/div[2]/ul/li[7]")).click();
        // get out of language
        chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).click();
        //Skills
        Select skill = new Select(chrome.findElement(By.id("Skills")));
        skill.selectByValue("Java");
        //country
        Select country = new Select(chrome.findElement(By.id("country")));
        country.selectByValue("United States of America");
        //year
        Select year = new Select(chrome.findElement(By.id("yearbox")));
        year.selectByValue("1978");
        //month
        Select month = new Select(chrome.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select")));
        month.selectByValue("September");
        //day
        Select day = new Select(chrome.findElement(By.id("daybox")));
        day.selectByValue("22");
        //password
        chrome.findElement(By.id("firstpassword")).sendKeys("12345676");
        chrome.findElement(By.id("secondpassword")).sendKeys("12345676");
        //photo
        WebElement browse = chrome.findElement(By.id("imagesrc"));
        //click on ‘Choose file’ to upload the desired file
        browse.sendKeys("https://pbs.twimg.com/profile_images/1410016948977422337/rKU8iR89_400x400.png"); //Uploading the file using sendKeys
        System.out.println("File is Uploaded Successfully");
        //submit button
        chrome.findElement(By.id("submitbtn")).click();

    }


}
