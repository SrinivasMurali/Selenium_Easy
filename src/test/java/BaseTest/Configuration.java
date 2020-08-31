package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Configuration {
    public static WebDriver driver;
    public static Properties prop;

    public void openBrowser(String browser) {
        if (prop == null)
            prop = new Properties();
        try {
            FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//properties//config.properties");
            prop.load(fs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (browser.equals("Firefox")) {
            System.getProperty("webdriver.gecho.driver", System.getProperty("user.dir") + "driver.win.gechodriver.exe");
            driver = new FirefoxDriver();

        } else if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            String downloadFilepath = System.getProperty("user.dir") + "/src/test/resources/DownloadedFile";
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", downloadFilepath);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);
            driver = new ChromeDriver(options);
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void navigate_To_URL(String selenium_easy_url) throws Exception {
        driver.get(prop.getProperty(selenium_easy_url));
    }
}
