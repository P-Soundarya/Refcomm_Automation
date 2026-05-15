package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("timeout"))));

        PageFactory.initElements(driver, this);
    }

    // Wait for element visibility
    protected WebElement waitForVisibility(WebElement element) {

        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    // Wait for element clickability
    protected WebElement waitForClickability(WebElement element) {

        return wait.until(
                ExpectedConditions.elementToBeClickable(element));
    }

    // Click action
    protected void click(WebElement element) {

        waitForClickability(element).click();
    }

    // Type action
    protected void type(WebElement element, String text) {

        WebElement el = waitForVisibility(element);

        el.clear();
        el.sendKeys(text);
    }

    // Get text
    protected String getText(WebElement element) {

        return waitForVisibility(element).getText();
    }

    // Check element displayed
    protected boolean isDisplayed(WebElement element) {

        try {

            return waitForVisibility(element).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    // Navigate
    public void navigateTo(String url) {

        driver.get(url);
    }

    // Get page title
    protected String getPageTitle() {

        return driver.getTitle();
    }

protected void waitForUrlContains(String text) {

    wait.until(
            ExpectedConditions.urlContains("dashboard"));
}}