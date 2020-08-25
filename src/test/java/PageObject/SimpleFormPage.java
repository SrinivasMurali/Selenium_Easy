package PageObject;

import BaseTest.BrowserBot;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.ShortMessage;

public class SimpleFormPage extends BrowserBot {

    public SimpleFormPage(WebDriver driver) throws Exception{
        super(driver);
    }
    public static final String ENTER_MESSAGE    = "//label[text()='Enter message']/parent::div/input",
                                SHOW_MESSAGE    = "//button[text()='Show Message']",
                               MESSAGE_PART_1   = "//div/label[text()='Your Message: ']/parent::div/span[text()='",
                               CLOSE_XPATH      = "']",
                               MESSAGE_A        = "//div/label[text()='Enter a']/parent::div/input",
                               MESSAGE_B        = "//div/label[text()='Enter b']/parent::div/input",
                               GET_TOTAL        = "//button[text()='Get Total']",
                               TOTAL            = "//div/span[text()='";



    public void enterMessage(String message) throws Exception{
        waitForElementAppearance(ENTER_MESSAGE, "xpath");
        sendKeys(ENTER_MESSAGE, "xpath", message);
    }

    public void showMessage() throws Exception{
        click(SHOW_MESSAGE, "xpath");
    }

    public void verifyMessage(String message) throws Exception{
       waitForElementAppearance(MESSAGE_PART_1 +message + CLOSE_XPATH, "xpath");
       verifyTextIsPresent(MESSAGE_PART_1 +message+ CLOSE_XPATH, "xpath", "Expected message is not display");
    }

    public void enterMessageInAfield(String message) throws Exception{
   waitForElementAppearance(MESSAGE_A, "xpath");
   sendKeys(MESSAGE_A, "xpath", message);
    }

    public void enterMessageInBField(String message) throws Exception{
        sendKeys(MESSAGE_B, "xpath", message);
    }

    public void get_Total() throws Exception{
      click(GET_TOTAL, "xpath");
    }

    public void verifyTotal(String total) throws Exception{
        System.out.println(TOTAL +total+ CLOSE_XPATH);
       waitForElementAppearance(TOTAL +total+ CLOSE_XPATH, "xpath");
       verifyTextIsPresent(TOTAL +total+ CLOSE_XPATH, "xpath", "Total is not display");
    }
}
