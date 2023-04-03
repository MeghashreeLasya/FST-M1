package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activities",
        plugin = {"pretty","html: reports/HTML_Report.html",
        "junit:reports/JUnit_Report.xml",
        "json:reports/JSON_report.json"},
        monochrome = true,
        publish = true
)

public class ActivitiesRunner {
    //empty
}