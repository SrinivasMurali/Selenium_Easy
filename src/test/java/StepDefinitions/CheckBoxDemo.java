package StepDefinitions;

import BaseTest.Configuration;
import PageObject.CheckBoxDemoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxDemo extends Configuration {
    public WebDriver driver;
    public CheckBoxDemo() throws Exception{
    }

    CheckBoxDemoPage checkboxDemo = PageFactory.initElements(driver, CheckBoxDemoPage.class);

    @When("^Click single checkbox demo option$")
    public void singleCheckBox() throws Exception {
        checkboxDemo.singleCheckBox();
    }

    @When("^Verify check box selected success message$")
    public void verifySingleCheckBoxIsSelected() throws Exception {
        checkboxDemo.singleCheckBoxIsSelected();
    }

    @When("Select check all button")
    public void checkAll() throws Exception {
        checkboxDemo.checkAll();
    }

    @When("Verify all check boxes are selected")
    public void verifyUncheckAllMessage(int count) throws Exception {
        checkboxDemo.verifyUncheckAllMessage();
    }

    @When("Verify alternative check boxes are selected")
    public void VerifyAlternativeCheckBoxesareSelected(int count) throws Exception {
        checkboxDemo.VerifyAlternativeCheckBoxesareSelected();
    }

    @When("Select alternative check boxes")
    public void selectAlternativeCheckBoxes(int count) throws Exception {
        checkboxDemo.selectAlternativeCheckBoxes(count);
    }

}
