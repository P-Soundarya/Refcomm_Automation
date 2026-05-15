package utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    private int count = 0;
    private static final int maxRetry = 1;

    @Override
    public boolean retry(ITestResult result) {

        if (count < maxRetry) {

            count++;

            System.out.println(
                    "Retrying test: "
                            + result.getName());

            return true;
        }

        return false;
    }
}