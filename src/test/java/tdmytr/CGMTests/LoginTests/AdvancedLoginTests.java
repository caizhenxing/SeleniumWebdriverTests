package tdmytr.CGMTests.LoginTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tdmytr.CGMAutomationFramework.Pages.BasePage;
import tdmytr.CGMAutomationFramework.Pages.LoginPage;
import tdmytr.CGMAutomationFramework.Workflow.ToastMessage;
import tdmytr.CGMTests.Utilities.CGMTest;

public class AdvancedLoginTests extends CGMTest
{
    @Test
    public void Cannot_Login_With_Invalid_Credentials()
    {
        if (BasePage.IsAt())
        {
            BasePage.Logout();
            Assert.assertTrue(LoginPage.IsAt());
        }
        LoginPage.LoginAs("g3his").WithPassword("123").Login();

        Assert.assertTrue(ToastMessage.IsLoginFailed());
    }
}
