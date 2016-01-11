package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainPageTests extends TestBase {

    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass
    public void testClassSetup(){
        this.loginPage = new LoginPage();
        this.mainPage = this.loginPage.logInAs(ConfigProvider.getValidUserName(), ConfigProvider.getValidUserPassword()).proceedWithMainPage();
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