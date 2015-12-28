package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class MainPageTests extends TestBase {

    MainPage mainPage;
    LoginPage loginPage;

    @BeforeClass
    public void testClassSetup(){
        this.loginPage = new LoginPage(RemoteBrowser.getWebDriverInstance());

        try {
            super.pages.logInAs(ConfigProvider.getValidUserName(), ConfigProvider.getValidUserPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.mainPage = new MainPage(RemoteBrowser.getWebDriverInstance());

        RemoteBrowser.implicitWait(10);
    }

    @Test(groups = {"group2"})
    public void menuButtonIsDisplayed(){
        boolean result = this.mainPage.menuButtonIsDisplayed();
        Assert.assertTrue(result, "Menu button doesn't exist on the page");
    }

    @Test (groups = {"group2"})
    public void userCanLogOut() {
        boolean result = this.mainPage.clickUserButton().clickLogOut().logInButtonIsDisplayed();
        Assert.assertTrue(result, "User cannot logout");
    }
}
