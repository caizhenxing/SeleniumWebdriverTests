package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeClass
    public void testClassSetup(){
        this.loginPage = new LoginPage(super.driver);
    }

    @Test (groups = {"group2"})
    public void userCannotLogInWithInvalidCredentials() throws InterruptedException {
            super.pages.logInAs(ConfigProvider.getInvalidUserName(), ConfigProvider.getInvalidUserPassword());

        String warningMessage = this.loginPage.getWarningMessage();

        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Messages are not equal");
    }
}
