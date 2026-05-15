package tests;

import base.ConfigReader;
import base.DriverFactory;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;

public class HomeTest extends BaseTest{

   

    @Test
    public void verifyHomePageLoads() {

        HomePage homePage =
                new HomePage(DriverFactory.getDriver());

        homePage.openHomePage();

//        Assert.assertTrue(
//                homePage.getTitle().length() > 0);
    }

   
}