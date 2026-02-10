package org.mac.base;

import org.mac.core.waits.WaitManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitManager wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver,10);
    }

    /* ================================
       CORE FIND METHOD
    ================================= */
    protected WebElement find(By locator) {
        return wait.waitForVisible(locator);
    }

    /* ================================
       BASIC ACTIONS
    ================================= */
    protected void click(By locator) {
        wait.waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /* ================================
       SAFE ACTIONS (AUTO-RECOVERY)
    ================================= */
    protected void safeClick(By locator) {
        try {
            click(locator);
        } catch (ElementClickInterceptedException | TimeoutException e) {
            WebElement element = driver.findElement(locator);
            scrollIntoView(locator);
            jsClick(locator);
        }
    }

    protected void safeType(By locator, String text) {
        try {
            type(locator, text);
        } catch (StaleElementReferenceException e) {
            WebElement element = find(locator);
            element.clear();
            element.sendKeys(text);
        }
    }

    /* ================================
       WAIT HELPERS
    ================================= */
    protected void waitForVisibility(By locator) {
        wait.waitForVisible(locator);
    }

    protected void waitForClickable(By locator) {
        wait.waitForClickable(locator);
    }

    /* ================================
       JS UTILITIES
    ================================= */
    protected void jsClick(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void scrollIntoView(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected void highlight(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='2px solid red'", element);
    }

    /* ================================
       MOUSE ACTIONS
    ================================= */
    protected void hover(By locator) {
        new Actions(driver).moveToElement(find(locator)).perform();
    }

    protected void doubleClick(By locator) {
        new Actions(driver).doubleClick(find(locator)).perform();
    }

    protected void rightClick(By locator) {
        new Actions(driver).contextClick(find(locator)).perform();
    }

    /* ================================
       NAVIGATION HELPERS
    ================================= */
    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected void goBack() {
        driver.navigate().back();
    }

    protected void goForward() {
        driver.navigate().forward();
    }

    protected String getPageTitle() {
        return driver.getTitle();
    }
}