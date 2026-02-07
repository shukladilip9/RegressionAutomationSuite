package org.mac.pages;

import org.apache.logging.log4j.Logger;
import org.mac.base.BasePage;
import org.mac.core.logger.LogManagerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final Logger log = LogManagerUtil.getLogger(LoginPage.class);

    private final By inputUsername = By.name("username");
    private final By inputPassword = By.name("password");
    private final By buttonLogin   = By.xpath("//button[normalize-space()='Login']");

    public LoginPage(WebDriver driver) {
        super(driver);
        log.info("LoginPage initialized");
    }

    public LoginPage enterUsername(String username) {
        log.info("Entering username: {}", username);
        safeType(inputUsername, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        log.info("Entering password");
        safeType(inputPassword, password);
        return this;
    }

    public DashboardPage clickLoginButton() {
        log.info("Clicking Login button");
        safeClick(buttonLogin);
        return new DashboardPage(driver);
    }

    public DashboardPage loginAs(String username, String password) {
        log.info("Attempting login for user: {}", username);
        DashboardPage dashboard = enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();

        log.info("Login action submitted for user: {}", username);
        return dashboard;
    }
}