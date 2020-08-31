package StepDefinitions;

import BaseTest.Configuration;
import Data.Simple_Form_Data;
import PageObject.SimpleFormPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SimpleFormDemo extends Configuration {
    public WebDriver driver;

    public SimpleFormDemo() throws Exception {
    }

    SimpleFormPage simpleForm = PageFactory.initElements(driver, SimpleFormPage.class);
    Simple_Form_Data simpleFormData = new Simple_Form_Data();

    @When("Enter string in message field \"(.*?)\"")
    public void message(String message) throws Exception {
        simpleForm.enterMessage(message);
    }

    @When("^click on show message button$")
    public void showButton() throws Exception{
        simpleForm.showMessage();
    }

    @Then("Verify display string message is expected$")
    public void verifyMessage() throws Exception{
        simpleForm.verifyMessage(simpleFormData.SHOW_MESSAGE);
    }

    @When("Enter number in a field \"(.*?)\"")
    public void messageInAField(String message) throws Exception{
        simpleForm.enterMessageInAfield(message);
    }

    @When("Enter number in b field \"(.*?)\"")
    public void messageInBField(String message) throws Exception{
        simpleForm.enterMessageInBField(message);
    }

    @When("Click on get total button")
    public void clickOnTotal() throws Exception{
        simpleForm.get_Total();
    }

    @When("Verify a and b total values are correct \"(.*?)\"")
    public void verifyTotal(String total) throws Exception{
        simpleForm.verifyTotal(total);
    }


}
