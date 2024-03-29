package CGMTests.Tests.nhrytsko.tests;

import CGMTests.Pages.WebPageBase;
import CGMTests.Pages.MainPage;
import CGMTests.Tests.TestBase;
import WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainPageTestSuite extends TestBase {

    MainPage mainPage;
    String browserName;

    @BeforeClass
    @Parameters(value = {"hub", "driverName", "port"})
    public void classSetUp(String hub, String browserName, String port){
        this.mainPage = WebPageBase.startBrowser(hub, browserName, port).goToStartPage()
                .logInAs(ConfigProvider.getValidUserName(), ConfigProvider.getValidUserPassword()).proceedWithMainPage();
        this.browserName = browserName;
    }

    @Test(groups = {"group2"})
    public void menuButtonIsDisplayed(){
        boolean result = this.mainPage.menuButtonIsDisplayed();
        Assert.assertTrue(result, "Menu button doesn't exist on the page");
        System.out.println("Test is running the thread #"+Thread.currentThread().getId()  + " in browser " + this.browserName);
    }

    @Test (groups = {"group2"})
    public void userCanLogOut() {
        boolean result = this.mainPage.clickUserButton().clickLogOut().logInButtonIsDisplayed();
        Assert.assertTrue(result, "User cannot logout");
        System.out.println("Test is running the thread #"+Thread.currentThread().getId()  + " in browser " + this.browserName);
    }
}