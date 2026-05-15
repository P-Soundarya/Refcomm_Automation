package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                        result.getMethod().getMethodName());

        test.fail(result.getThrowable());

        test.addScreenCaptureFromPath(
                screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}