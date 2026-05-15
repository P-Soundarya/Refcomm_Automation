package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import base.DriverFactory;

public class BaseTest {

    @Parameters({"browser", "headless", "resolution"})
    @BeforeMethod
    public void setup(String browser, String headless, String resolution) {
    	System.out.println("===== SETUP STARTED =====");

        System.out.println("Browser: " + browser);
        System.out.println("Headless: " + headless);
        System.out.println("Resolution: " + resolution);
        DriverFactory.initDriver(browser, headless, resolution);
        System.out.println("===== DRIVER INITIALIZED =====");
    }

    @AfterMethod
    public void tearDown() {
    	 System.out.println("===== TEARDOWN STARTED =====");
        DriverFactory.quitDriver();
    }
}