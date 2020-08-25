package StepDefinitions;

import BaseTest.Configuration;
import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Hooks extends Configuration {
    @Before
    public void openBrowser() throws Exception {
        openBrowser("Chrome");
    }

    @After(order = 0)
    public void embededScreenShot(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            try {
                final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wd) {
                System.err.println(wd.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }

        }
        driver.quit();
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            Date d = new Date();
            String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
            try {
                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destinationPath = new File(
                        System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotFile);
                Files.copy(scrFile, destinationPath);
                Reporter.addScreenCaptureFromPath(destinationPath.toString());
            } catch (IOException e) {
            }
        }
    }
}
