package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {
	 public LoginPage(WebDriver driver) {

	        super(driver);
	    }

	    // Email Input
	    @FindBy(xpath = "//input[@type='email']")
	    private WebElement emailInput;
	    
	    // Password Input
	    @FindBy(xpath = "//input[@type='password']")
	    private WebElement passwordInput;

	    // Login Button
	    @FindBy(xpath = "//button[@type='submit']")
	    private WebElement loginButton;

	    // Error Message
	    @FindBy(xpath = "//*[contains(text(),'Invalid')]")
	    private WebElement errorMessage;
	   
	    

	    public void enterEmail(String email) {

	        type(emailInput, email);
	    }
	    

	    public void enterPassword(String password) {

	        type(passwordInput, password);
	    }

	    public void clickLogin() {

	        click(loginButton);
	    }

	    public void login(String email, String password) {
	    	
	        enterEmail(email);
	        enterPassword(password);
	        clickLogin();
	        waitForUrlContains("dashboard");
	    }

	    public boolean isErrorMessageDisplayed() {

	        return isDisplayed(errorMessage);
	    }
}
