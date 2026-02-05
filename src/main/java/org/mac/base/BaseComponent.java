package org.mac.base;

import org.mac.core.waits.WaitManager;
import org.openqa.selenium.WebDriver;

public abstract class BaseComponent {

    protected WebDriver driver;
    protected WaitManager wait;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitManager(driver);
    }
}
