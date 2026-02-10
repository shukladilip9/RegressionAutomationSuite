package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.mac.core.config.ConfigManager;
import org.mac.core.driver.DriverManager;
import org.mac.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before
    public void setUp() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigManager.getBaseUrl());
        DriverManager.setDriver(driver);  // ⭐ driver available for steps
    }

    @After
    public void tearDown(io.cucumber.java.Scenario scenario) {

        if (scenario.isFailed()) {
            ScreenshotUtils.captureScreenshot(scenario.getName());
        }

        DriverManager.quitDriver();
    }
}