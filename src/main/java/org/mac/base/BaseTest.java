package org.mac.base;

import org.mac.core.config.ConfigManager;
import org.mac.core.driver.DriverConfig;
import org.mac.core.driver.DriverFactory;
import org.mac.core.driver.DriverManager;
import org.mac.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {

        DriverConfig config = new DriverConfig.Builder()
                .browser(ConfigManager.getBrowser())
                .headless(false)
                .implicitWait(10)
                .build();

        WebDriver driver = DriverFactory.createDriver(config);
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(ConfigManager.getBaseUrl());

        System.out.println("DRIVER STARTED: " + driver);
    }

    protected WebDriver getDriver() {
        return DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.captureScreenshot(result.getName());
        }
        DriverManager.quitDriver();
    }
}