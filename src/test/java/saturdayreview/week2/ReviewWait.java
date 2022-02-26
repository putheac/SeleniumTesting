package saturdayreview.week2;

import com.sun.jdi.ByteValue;
import com.sun.jna.Structure;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReviewWait {


    WebDriver driver;

    @Before
    public void beforeMethod() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/checkboxradio/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void click() throws InterruptedException {
        // this code we will learn next week

//        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
//        // print your number of frames
//        System.out.println(iframes.size());
//
//
//        driver.findElement(By.xpath("//iframe")).getSize();

        driver.switchTo().frame(0);

        List<WebElement> checkboxradioSections = driver.findElements(By.xpath("/html/body/div/fieldset"));

        for (WebElement eachSection : checkboxradioSections) {
            String eachSec = eachSection.getText();
//            System.out.println("-----------------\n"+eachSec+"\n-------------------");

            if (eachSec.contains("Location")) {

                List<WebElement> locationRadioButtons = driver
                        .findElements(By.xpath("/html/body/div/fieldset[1]/label"));

                for (WebElement eachLocationRadioButton : locationRadioButtons) {

                    if (eachLocationRadioButton.getText().contains("Paris")) {
                        eachLocationRadioButton.click();
                    }
                }

            }

            if (eachSec.contains("Hotel")) {
                List<WebElement> HotelRadiocheckbox = driver.findElements(By.xpath("/html/body/div/fieldset[2]/label"));

                for (WebElement eachHotelRating : HotelRadiocheckbox) {

                    if (eachHotelRating.getText().contains("2 Star")) {
                        eachHotelRating.click();
                    }
                    if (eachHotelRating.getText().contains("3 Star")) {
                        eachHotelRating.click();
                    }

                }

            }

            if (eachSec.contains("Bed")) {
                List<WebElement> bedTypeCheckbox = driver.findElements(By.xpath("/html/body/div/fieldset[3]/label"));

                for (WebElement eachBedType : bedTypeCheckbox) {

                    if (eachBedType.getText().contains("2 Double")) {
                        eachBedType.click();
                    }

                    if (eachBedType.getText().contains("1 Queen")) {
                        eachBedType.click();
                    }

                    if (eachBedType.getText().contains("1 King")) {
                        eachBedType.click();
                    }
                }

            }

        }

        driver.switchTo().parentFrame();
        // driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//*[@id=\"menu-top\"]/li[1]/a")).click();
    }

}
