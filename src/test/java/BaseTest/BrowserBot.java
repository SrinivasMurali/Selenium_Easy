package BaseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertTrue;

public class BrowserBot {
    public static WebDriver driver;
    protected static long pageWaitTimeout = 30;
    public static final int WAIT_TIME_SHORTDURATION = 15;
    public static final int WAIT_TIME = 40;

    public BrowserBot(WebDriver driver) throws Exception {
        BrowserBot.driver = Configuration.driver;
    }

    public enum type {
        xpath, css, id, name, tagName, linktext, className;
    }

    public static By getWebDriverBy(String elementName, String locatorStrategy) throws Exception {
        By webdriverby = null;

        switch (type.valueOf(locatorStrategy)) {
            case xpath:
                webdriverby = By.xpath(elementName);
                break;
            case css:
                webdriverby = By.cssSelector(elementName);
                break;
            case id:
                webdriverby = By.id(elementName);
                break;
            case name:
                webdriverby = By.name(elementName);
                break;
            case tagName:
                webdriverby = By.tagName(elementName);
                break;
            case linktext:
                webdriverby = By.linkText(elementName);
                break;
            case className:
                webdriverby = By.className(elementName);
        }
        return webdriverby;
    }

    public WebElement getElement(String elementName, String locatorStrategy) throws Exception {
        WebElement element = driver.findElement(getWebDriverBy(elementName, locatorStrategy));
        return element;
    }

    /************************** Wait Functions ***********************************/
    public void waitForElementAppearance(String elementName, String locatorStrategy) throws Exception {
        new WebDriverWait(driver, WAIT_TIME_SHORTDURATION)
                .until(ExpectedConditions.presenceOfElementLocated(getWebDriverBy(elementName, locatorStrategy)));
    }

    public WebElement waitForElementIsVisible(String elementName, String locatorStrategy) throws Exception {
        WebElement element = getElement(elementName, locatorStrategy);
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void sendKeys(String elementName, String locatorStrategy, String keys) throws Exception {
        waitForElementIsVisible(elementName, locatorStrategy);
        getElement(elementName, locatorStrategy).clear();
        getElement(elementName, locatorStrategy).sendKeys(keys);
    }

    public void waitForElementToBeClickable(String elementName, String locatorStrategy) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(getElement(elementName, locatorStrategy)));
    }

    public void click(String elementName, String locatorStrategy) throws Exception {
        waitForElementToBeClickable(elementName, locatorStrategy);
        getElement(elementName, locatorStrategy).click();
    }

    // click by JavaScript
    public void clickByJS(String elementName, String locatorStrategy) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", getElement(elementName, locatorStrategy));
    }

    /************* DropDown Functions ********************/
    public void selectVisibleText(String elementName, String locatorStrategy, String VisibleText) throws Exception {
        Select selObj = new Select(getElement(elementName, locatorStrategy));
        selObj.selectByVisibleText(VisibleText);
    }

    /************** Verification Functions *********************/

    public void verifyTextIsPresent(String elementName, String locatorStrategy, String errorMessage) throws Exception {
        assertTrue(isElementPresent(elementName, locatorStrategy), errorMessage);
    }

    public boolean isElementPresent(String elementName, String locatorStrategy) {
        try {
            if (driver.findElements(getWebDriverBy(elementName, locatorStrategy)).size() != 0) {
                return true;

            } else {
                return false;
            }
        } catch (WebDriverException e) {
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText(String elementName, String locatorStrategy) throws Exception {
        String text = getElement(elementName, locatorStrategy).getText();
        return text;
    }
}
