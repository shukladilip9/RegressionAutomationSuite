package org.mac.pages;
import org.mac.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By inputUsername = By.id("user");
    private final By inputPassword = By.id("pass");
    private final By buttonLogin = By.id("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage enterUsername(String username) {
        enterText(inputUsername, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(inputPassword, password);
        return this;
    }

    public DashboardPage clickLoginButton() {
        click(buttonLogin);
        return new DashboardPage(driver);
    }

    public DashboardPage loginAs(String username, String password) {
        return enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }
}
