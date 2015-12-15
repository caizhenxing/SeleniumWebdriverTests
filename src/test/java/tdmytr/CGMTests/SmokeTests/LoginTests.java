package tdmytr.CGMTests.SmokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tdmytr.CGMAutomationFramework.Pages.BasePage;
import tdmytr.CGMAutomationFramework.Pages.LoginPage;
import tdmytr.CGMTests.Utilities.CGMTest;

public class LoginTests extends CGMTest
{
    @Test
    public void Admin_User_Can_Login()
    {
        if (BasePage.IsAt())
        {
            BasePage.Logout();
            Assert.assertTrue(LoginPage.IsAt());
        }
        LoginPage.LoginAs("g3his").WithPassword("g3his").Login();

        Assert.assertTrue(BasePage.IsAt(), "Failed to login.");
    }
}
