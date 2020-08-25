package StepDefinitions;

import BaseTest.Configuration;
import PageObject.Home_Page;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home extends Configuration {
    public WebDriver driver;

    Home_Page home = PageFactory.initElements(driver, Home_Page.class);

    @When("^Select no thanks button in learn selenium automate window$")
    public void no_Thnaks() throws Exception {
        home.select_NO_Thanks_Window();
    }

    @Then("^Verify selenium easy page is display$")
    public void homePage() throws Exception {
        home.verifySeleniumHomePage();
    }

    @When("^Select simple form demo link$")
    public void simpleFormDemo() throws Exception {
        home.simpleFormDemo();
    }

    @When("^Select input forms link in menu list$")
    public void inputForms() throws Exception {
        home.inputForms();
    }

    @When("^Select checkbox demo link$")
    public void checkBoxDemo() throws Exception {
        home.checkBoxDemo();
    }


}