package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTests extends TestBase {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeClass
    public void testClassSetup(){
        this.loginPage = new LoginPage(RemoteBrowser.getWebDriverInstance());
    }

    @Test (groups = {"group2"})
    public void userCannotLogInWithInvalidCredentials() throws InterruptedException {
        try {
            super.pages.logInAs(ConfigProvider.getInvalidUserName(), ConfigProvider.getInvalidUserPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }

        String a = this.loginPage.getWarningMessage();

        Assert.assertEquals(a, "Login failed - Invalid user name or bad password.", "Messages are not equal");
    }
}
