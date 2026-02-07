package org.mac.base;

import org.mac.core.waits.WaitManager;
import org.openqa.selenium.*;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitManager waitManager;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitManager = new WaitManager(driver, 15);
        this.js = (JavascriptExecutor) driver;
    }

    protected void safeClick(By locator) {
        try {
            waitManager.waitForClickable(locator).click();
        } catch (Exception e) {
            jsClick(locator);
        }
    }
    protected boolean isDisplayed(By locator) {
        try {
            return waitManager.waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void safeType(By locator, String text) {
        WebElement element = waitManager.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void jsClick(By locator) {
        WebElement element = waitManager.waitForVisible(locator);
        js.executeScript("arguments[0].click();", element);
    }
}