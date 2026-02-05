package org.mac.base;

import org.mac.core.waits.WaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitManager wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver);
    }

    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected void enterText(By locator, String text) {
        wait.waitForVisible(locator).sendKeys(text);
    }

    protected String getElementText(By locator) {
        return wait.waitForVisible(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        return wait.waitForVisible(locator).isDisplayed();
    }
}
