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


public class Activity1 {
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
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    // Test method
    @Test
    public void googleTaskTest() throws InterruptedException {

        // Find heading on the page
        String s[] = {"Complete Activity with Google Tasks","Complete Activity with Google Keep","Complete the second Activity Google Keep"};

        for (int i=0;i<3;i++){

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")));
            driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Create new task\"]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_title")));
            driver.findElement(AppiumBy.id("add_task_title")).sendKeys(s[i]);

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.id("add_task_done")));
            driver.findElement(AppiumBy.id("add_task_done")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.FrameLayout[@content-desc='" + s[i] + "'])[1]/android.view.ViewGroup/android.widget.TextView")));
            // Assertion
            String messageTextSent = driver.findElement(AppiumBy.xpath("(//android.widget.FrameLayout[@content-desc='" + s[i] + "'])[1]/android.view.ViewGroup/android.widget.TextView")).getText();
            Assert.assertEquals(messageTextSent, s[i]);

        }

    }
    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}