package org.mac.base;

import org.mac.core.config.ConfigManager;
import org.mac.core.driver.DriverManager;
import org.mac.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(ConfigManager.getBaseUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        DriverManager.quitDriver();
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            ScreenshotUtils.captureScreenshot(result.getName());
        }
        DriverManager.quitDriver();
    }}
