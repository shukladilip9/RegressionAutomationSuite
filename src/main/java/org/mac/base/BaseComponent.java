package org.mac.base;

import org.mac.core.waits.WaitManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public abstract class BaseComponent {

    protected WebDriver driver;
    protected WaitManager wait;
    protected JavascriptExecutor js;
    protected Actions actions;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver, 15);
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }
}