package base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    // Thread-safe driver for parallel execution
    private static final ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static void initDriver(
            String browser,
            String headless,
            String resolution) {
    	System.out.println("===== INSIDE DRIVER FACTORY =====");
        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();

            // Headless Mode
            if (headless.equalsIgnoreCase("true")) {

                options.addArguments("--headless=new");
            }

            // CI Stability Options
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");

            // Browser maximization
            options.addArguments("--start-maximized");

            // Resolution handling
            if (resolution != null && !resolution.isEmpty()) {

                String[] res = resolution.split("x");

                if (res.length == 2) {

                    options.addArguments(
                            "--window-size="
                                    + res[0]
                                    + ","
                                    + res[1]);
                }
            }

            WebDriverManager.chromedriver().setup();
            System.out.println("===== CREATING CHROME DRIVER =====");

            driver.set(new ChromeDriver(options));
            System.out.println("===== DRIVER CREATED SUCCESSFULLY =====");

            // Selenium best practice waits
            getDriver().manage()
                    .timeouts()
                    .implicitlyWait(Duration.ofSeconds(0));

            getDriver().manage()
                    .timeouts()
                    .pageLoadTimeout(Duration.ofSeconds(30));

        } else {

            throw new IllegalArgumentException(
                    "Unsupported browser: " + browser);
        }
    }

    public static WebDriver getDriver() {

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null) {

            driver.get().quit();
            driver.remove();
        }
    }
}