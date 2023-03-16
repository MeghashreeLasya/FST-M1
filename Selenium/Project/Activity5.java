package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Activity5 {
    @Test

    public void verifyTitle() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account – Alchemy LMS");
        driver.quit();
    }
}