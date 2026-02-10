package org.mac.core.driver;

import org.mac.core.config.ConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static WebDriver createDriver(DriverConfig config) {

        String browser = config.getBrowser();

        if (browser.equalsIgnoreCase("browserstack")) {
            return createBrowserStackDriver(config);
        }

        WebDriver driver;

        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if (config.isHeadless()) {
                    options.addArguments("--headless=new");
                }
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                throw new RuntimeException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(config.getImplicitWait()));

        return driver;
    }
    private static WebDriver createBrowserStackDriver(DriverConfig config) {
        try {
            String USERNAME = System.getenv("BROWSERSTACK_USERNAME");
            String ACCESS_KEY = System.getenv("BROWSERSTACK_ACCESS_KEY");

            String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

            ChromeOptions options = new ChromeOptions();
            options.setBrowserVersion("latest");

            Map<String, Object> bstackOptions = new HashMap<>();
            bstackOptions.put("os", "Windows");
            bstackOptions.put("osVersion", "11");
            bstackOptions.put("sessionName", "Parallel Test");
            bstackOptions.put("buildName", "Regression Suite");
            bstackOptions.put("projectName", "MAC Automation");

            options.setCapability("bstack:options", bstackOptions);

            return new RemoteWebDriver(new URL(URL), options);

        } catch (Exception e) {
            throw new RuntimeException("Failed to create BrowserStack session", e);
        }
    }
}