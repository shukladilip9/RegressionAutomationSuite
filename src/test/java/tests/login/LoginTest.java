package tests.login;

import org.mac.base.BaseTest;
import org.mac.core.driver.DriverManager;
import org.mac.pages.DashboardPage;
import org.mac.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserCanLoginSuccessfully() {
        LoginPage loginPage = new LoginPage(getDriver());
        DashboardPage dashboardPage = loginPage.loginAs("Admin", "admin123");
        Assert.fail();
        //Assert.assertTrue(dashboardPage.isDashboardLoaded());
    }

    @Test
    public void testStringEquality(){
        Assert.assertTrue(true);
    }
}
