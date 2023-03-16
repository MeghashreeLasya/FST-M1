package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Activity9 {
    @Test

    public void verifyComplete() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='My Account']")).click();
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account – Alchemy LMS");
        driver.findElement(By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")).click();
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("root");
        driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("pa$$w0rd");
        driver.findElement(By.xpath("//input[@id='wp-submit']")).click();
        String heading = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']")).getText();
        Assert.assertEquals(heading,"My Account");
        driver.findElement(By.xpath("//a[text()='All Courses']")).click();
        List<WebElement> courses = driver.findElements(By.xpath("//div[@class='ld_course_grid col-sm-8 col-md-4 ']"));
        System.out.println("No.of courses  "+courses.size());
        if(courses.size()>0) {
           courses.get(0).click();
        }
        driver.findElement(By.xpath("//div[@data-ld-expands='ld-expand-83']")).click();
        driver.findElement(By.xpath("//span[text()='This is the First Topic']")).click();
        String status = driver.findElement(By.xpath("//div[@class='ld-status ld-status-complete ld-secondary-background']")).getText();
        Assert.assertEquals(status,"COMPLETE");
        driver.quit();
    }
}

