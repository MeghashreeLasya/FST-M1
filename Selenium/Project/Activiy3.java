package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activiy3 {
    @Test

    public void verifyText() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        Thread.sleep(2000);
        String heading = driver.findElement(By.xpath("//h3[@class='uagb-ifb-title']")).getText();
        Assert.assertEquals(heading, "Actionable Training");
        driver.quit();
    }
}