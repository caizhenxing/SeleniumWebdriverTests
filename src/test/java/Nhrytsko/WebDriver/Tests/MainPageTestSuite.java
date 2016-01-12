package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTestSuite extends TestBase {

    PageBase pages;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass
    @Parameters(value = {"hub", "browserName"})
    public void testClassSetup(String hub, String browserName){
        PageBase.startBrowser(hub, browserName);
        this.pages = new PageBase();
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