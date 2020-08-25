package TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features",
        plugin = {"html:target/cucumber-html-report", // html report
                "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt", // text report
                "usage:target/cucumber-usage.json", "junit:target/cucumber-results.xml", // xml report
                "pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json", // Report
                "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/ExtentReport.html",// Extent
                },
        glue = {"StepDefinitions"},
        monochrome = true, // display the console output in a proper readable format
        strict = true, // it will check if any step is not defined in step definition file
        dryRun = false, // to check the mapping is proper between feature file and step def file
        tags = {"@SingleInputField, @TwoInputField"}
)
public class Run_Cucumber_Test {
    @AfterClass()
    public static void setup() throws Exception {

    }

}
