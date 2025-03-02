package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


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
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome
        driver.get("https://www.training-support.net");
    }

    // Test method
    @Test
    public void chromeTest() throws InterruptedException {
        // Find heading on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'Training Support')]")));

        String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'Training Support')]")).getText();

        // Print to console
        System.out.println("Heading: " + pageHeading);

        // Find and click the About Us link
        driver.findElement(AppiumBy.xpath("//android.view.View[contains(@resource-id,'about-link')]")).click();

        // Find heading of new page and print to console
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@text,'About Us')]")));
        String aboutPageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[contains(@text,'About Us')]")).getText();
        System.out.println(aboutPageHeading);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}