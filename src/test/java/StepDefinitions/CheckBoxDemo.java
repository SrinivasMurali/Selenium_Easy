package StepDefinitions;

import BaseTest.Configuration;
import PageObject.CheckBoxDemoPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
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

    @Then("^Verify check box selected success message$")
    public void verifySingleCheckBoxIsSelected() throws Exception {
        checkboxDemo.singleCheckBoxIsSelected();
    }

    @When("Select check all button")
    public void checkAll() throws Exception {
        checkboxDemo.checkAll();
    }

    @Then("Verify all check boxes are selected")
    public void verifyUncheckAllMessage(int count) throws Exception {
        checkboxDemo.verifyUncheckAllMessage();
    }

    @Then("Verify alternative check boxes are selected")
    public void VerifyAlternativeCheckBoxesareSelected(int count) throws Exception {

    }

    @When("Select alternative check boxes")
    public void selectAlternativeCheckBoxes(int count) throws Exception {
        checkboxDemo.selectAlternativeCheckBoxes(count);
    }

    @When("Select uncheck all button")
    public void unCheckAll() throws Exception {
        checkboxDemo.uncheckAll();
    }

    @Then("Verify all check boxes are unselected")
    public void verifyCkeckAllButton() throws Exception {
        checkboxDemo.verifyCheckAllButton();
    }

    @Then("Verify uncheck all button appears")
    public void verifyUncheckAllButtonIsDisplay() throws Exception {
        checkboxDemo.verifyUncheckAllButtonIsDisplay();
    }

    @When("Select first three check box")
    public void selectFirstThreeChkBoxes() throws Exception {
        checkboxDemo.selectFirstThreeChkBoxes();
    }

}
