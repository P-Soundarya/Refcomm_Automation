package tests;

import org.jspecify.annotations.Nullable;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.DriverFactory;

import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void verifyLoginPageLoads() {

        HomePage homePage =new HomePage(DriverFactory.getDriver());

        homePage.openHomePage();

        homePage.clickLoginMenu();

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("login"));
    }

    @Test
    public void verifyInvalidLogin() {

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        homePage.openHomePage();

        homePage.clickLoginMenu();

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
        		
                "fake@test.com",
                "wrongpassword");
        loginPage.clickLogin();

        Assert.assertTrue(
                loginPage.isErrorMessageDisplayed(),
                "Error message not displayed");
    }
    @Test(retryAnalyzer = utils.RetryAnalyzer.class)
    public void verifyvalidLogin() {

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        homePage.openHomePage();

        homePage.clickLoginMenu();

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
        		
                "soundaryapacharya@gmail.com",
                "Sound@123");
        loginPage.clickLogin();
        @Nullable
		String url = DriverFactory.getDriver().getCurrentUrl();
        System.out.println(url);

        Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("dashboard"));
        
                
    }
}