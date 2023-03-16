package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Activity8 {
    @Test

    public void verifyContact() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/lms/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[text()='Contact']")).click();
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_0']")).sendKeys("Hemalatha");
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_1']")).sendKeys("hema.1205@gmail.com");
        driver.findElement(By.xpath("//input[@id='wpforms-8-field_3']")).sendKeys("Testing the subject");
        driver.findElement(By.xpath("//textarea[@id='wpforms-8-field_2']")).sendKeys("Testing the comment section");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String text = driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']")).getText();
        System.out.println(text);
        driver.quit();
    }
}
