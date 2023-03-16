package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Activity4{
    @Test

    public void verifyText() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        Thread.sleep(2000);
        List<WebElement> courses = driver.findElements(By.xpath("//h3[@class='uagb-ifb-title'][2]"));
        if(courses.size()>0) {
            String myText = courses.get(1).getText();

            Assert.assertEquals(myText, "Email Marketing Strategies");
        }
        driver.quit();
    }
}