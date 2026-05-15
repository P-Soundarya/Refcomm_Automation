package pages;

import base.BasePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {

        super(driver);
    }
    @FindBy(xpath="//button[text()='Sign In']")
    private WebElement loginMenu;
    public void openHomePage() {
    	System.out.println("-----opening web page----- ");

        navigateTo("https://refcomm-frontend-mvp-production.up.railway.app/");
    }	
    
    public void clickLoginMenu() {
    	click(loginMenu);
    }
    public String getTitle() {

        return getPageTitle();
    }
}