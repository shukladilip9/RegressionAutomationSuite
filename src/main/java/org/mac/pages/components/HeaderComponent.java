package org.mac.pages.components;

import org.mac.base.BaseComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BaseComponent {

    private final By iconProfile = By.id("profileIcon");
    private final By buttonLogout = By.id("logoutBtn");

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public void logout() {
        wait.waitForClickable(iconProfile).click();
        wait.waitForClickable(buttonLogout).click();
    }
}
