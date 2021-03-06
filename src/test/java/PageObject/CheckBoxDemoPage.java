package PageObject;

import BaseTest.BrowserBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckBoxDemoPage extends BrowserBot {
    public CheckBoxDemoPage(WebDriver driver) throws Exception {
        super(driver);
    }

    public static final String SINGLE_CHECK_BOX         = "isAgeSelected",
                               SINGLE_CHK_BOX_SELECTED  = "//div[text()='Success - Check box is checked']",
                               CHECK_BOX                = "(//input[@type='checkbox'])[",
                               CLOSE_BRACE              = "]",
                               UNCHECK_ALL              = "//input[@value='Uncheck All']",
                               CHECK_ALL                = "//input[@value='Check All']";

    public void singleCheckBox() throws Exception {
        waitForElementAppearance(SINGLE_CHECK_BOX, "xpath");
        clickByJS(SINGLE_CHECK_BOX, "xpath");
    }

    public void singleCheckBoxIsSelected() throws Exception {
        waitForElementAppearance(SINGLE_CHK_BOX_SELECTED, "xpath");
        verifyTextIsPresent(SINGLE_CHK_BOX_SELECTED, "xpath", "Success message is not display");
    }

    public void checkAll() throws Exception {
       waitForElementAppearance(CHECK_ALL, "xpath");
       click(CHECK_ALL, "xpath");
    }

    public void selectAlternativeCheckBoxes(int count) throws Exception {
        List<WebElement> checkBox = driver.findElements(By.xpath("//label/input[@type='checkbox']"));
        for(int i=0; i<checkBox.size(); i =i+2){
            checkBox.get(i).click();
        }
          }

    public void verifyUncheckAllMessage() throws Exception {
        waitForElementAppearance(UNCHECK_ALL, "xpath");
        verifyTextIsPresent(UNCHECK_ALL, "xpath", "Success message is not display");
    }

    public void verifyAlternativeCheckBoxesareSelected() throws Exception {
        waitForElementAppearance(UNCHECK_ALL, "xpath");
    }

    public void uncheckAll() throws Exception {
        waitForElementAppearance(UNCHECK_ALL, "xpath");
        click(UNCHECK_ALL, "xpath");
    }

    public void verifyCheckAllButton() throws Exception {
        waitForElementAppearance(CHECK_ALL, "xpath");
        verifyTextIsPresent(CHECK_ALL, "xpath", "Check all button is not displayed");
    }


    public void verifyUncheckAllButtonIsDisplay() throws Exception {
        waitForElementAppearance(UNCHECK_ALL, "xpath");
        verifyTextIsPresent(UNCHECK_ALL, "xpath", "UnCheck all button is not displayed");
    }

    public void selectFirstThreeChkBoxes() throws Exception {
        waitForElementAppearance(CHECK_ALL, "xpath");

    }

}
