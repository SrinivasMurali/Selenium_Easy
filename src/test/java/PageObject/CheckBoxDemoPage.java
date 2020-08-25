package PageObject;

import BaseTest.BrowserBot;
import org.openqa.selenium.WebDriver;

public class CheckBoxDemoPage extends BrowserBot {
    public CheckBoxDemoPage(WebDriver driver) throws Exception {
        super(driver);
    }

    public static final String SINGLE_CHECK_BOX         = "isAgeSelected",
                               SINGLE_CHK_BOX_SELECTED  = "//div[text()='Success - Check box is checked']",
                               CHECK_BOX                = "(//input[@type='checkbox'])[",
                               CLOSE_BRACE              = "]",
                               UNCHECK_ALL              = "//input[@value='Uncheck All']";

    public void singleCheckBox() throws Exception {
        waitForElementAppearance(SINGLE_CHECK_BOX, "xpath");
        clickByJS(SINGLE_CHECK_BOX, "xpath");
    }

    public void singleCheckBoxIsSelected() throws Exception {
        waitForElementAppearance(SINGLE_CHK_BOX_SELECTED, "xpath");
        verifyTextIsPresent(SINGLE_CHK_BOX_SELECTED, "xpath", "Success message is not display");
    }

    public void selectCheckBoxes(int count) throws Exception {
        for (int i = 1; i < count; i++) {
            click(CHECK_BOX + i + CLOSE_BRACE, "xpath");
        }
    }

    public void selectAlternativeCheckBoxes() throws Exception {

          }


    public void verifyUncheckAllMessage() throws Exception {
        waitForElementAppearance(UNCHECK_ALL, "xpath");
        verifyTextIsPresent(UNCHECK_ALL, "xpath", "Success message is not display");
    }


    public void VerifyAlternativeCheckBoxesareSelected() throws Exception {

          }

    public void alternativeCheckBoxes() throws Exception {

     }
}
