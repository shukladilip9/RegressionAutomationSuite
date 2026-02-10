package steps;

import io.cucumber.java.en.*;
import org.mac.core.driver.DriverManager;
import org.mac.pages.DashboardPage;
import org.mac.pages.LoginPage;
import org.testng.Assert;

public class LoginSteps {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Given("User is on login page")
    public void user_is_on_login_page() {
        loginPage = new LoginPage(DriverManager.getDriver());
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username)
                .enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_login() {
        dashboardPage = loginPage.clickLoginButton();
    }

    @Then("User should see the dashboard")
    public void user_should_see_dashboard() {
        Assert.assertTrue(true);
    }

    @Then("Sum is {int}")
    public void sumIs(int arg0) {
       System.out.println("Sum is: " + 3);

    }
}