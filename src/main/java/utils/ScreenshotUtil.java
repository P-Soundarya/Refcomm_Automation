package utils;

import base.DriverFactory;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {

    public static String captureScreenshot(String testName) {

        File src = ((TakesScreenshot)
                DriverFactory.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String path =
                System.getProperty("user.dir")
                        + "/test-output/screenshots/"
                        + testName
                        + ".png";

        File dest = new File(path);

        try {

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}