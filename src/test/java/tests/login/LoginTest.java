package tests.login;

import org.mac.base.BaseTest;
import org.mac.pages.DashboardPage;
import org.mac.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserCanLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.loginAs("admin", "password");

        Assert.assertTrue(dashboardPage.isDashboardLoaded());
    }
}
