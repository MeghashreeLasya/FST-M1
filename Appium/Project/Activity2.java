package liveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class Activity2 {
    // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Test method
    @Test
    public void googleKeepTest() throws InterruptedException {

        // Find heading on the page

        String title = "Google Keep Title";
        String description = "Hello, I am Meghashree. Adding a description here";

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("new_note_button")));
        driver.findElement(AppiumBy.id("new_note_button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("editable_title")));
        driver.findElement(AppiumBy.id("editable_title")).sendKeys(title);

        driver.findElement(AppiumBy.id("edit_note_text")).sendKeys(description);
        driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]")).click();


        // Assertion
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("browse_note_interior_content")));
        String title_1 = driver.findElement(AppiumBy.id("index_note_title")).getText();
        Assert.assertEquals(title_1,title);

        String description_1 = driver.findElement(AppiumBy.id("index_note_text_description")).getText();
        Assert.assertEquals(description_1,description);

    }

    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}