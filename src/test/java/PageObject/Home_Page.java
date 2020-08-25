package PageObject;

import BaseTest.BrowserBot;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class Home_Page extends BrowserBot {


    public Home_Page(WebDriver driver) throws Exception {
        super(driver);
    }

    public static final String NO_THANKS                = "//a[text()='No, thanks!']",
                               WELCOME_TO_SELENIUM      = "//h3[contains(text(),'Welcome to Selenium Easy ')]",
                               INPUT_FORMS              = "//a[text()='Input Forms']",
                               SIMPLE_FORM_DEMO         = "//a[text()='Simple Form Demo']",
                               CHECK_BOX_DEMO           = "//a[text()='Checkbox Demo']";


    public void verifySeleniumHomePage() throws Exception {
        waitForElementAppearance(WELCOME_TO_SELENIUM, "xpath");
        verifyTextIsPresent(WELCOME_TO_SELENIUM, "xpath", "Home page is not display");
    }

    public void select_NO_Thanks_Window() throws Exception {
        try {
            waitForElementAppearance(NO_THANKS, "xpath");
            if (isElementPresent(NO_THANKS, "xpath") == true) {
                click(NO_THANKS, "xpath");
            }
        } catch (NoSuchElementException e) {
        }
    }

    public void inputForms() throws Exception {
        waitForElementAppearance(INPUT_FORMS, "xpath");
        clickByJS(INPUT_FORMS, "xpath");
    }

    public void simpleFormDemo() throws Exception {
        waitForElementAppearance(SIMPLE_FORM_DEMO, "xpath");
        clickByJS(SIMPLE_FORM_DEMO, "xpath");
    }

    public void checkBoxDemo() throws Exception {
        waitForElementAppearance(CHECK_BOX_DEMO, "xpath");
        clickByJS(CHECK_BOX_DEMO, "xpath");
    }



}
