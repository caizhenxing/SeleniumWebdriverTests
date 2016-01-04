package ovol.Tests;

import Nhrytsko.WebDriver.Pages.*;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ovo on 28.12.2015.
 */
public class FastSearchTests extends TestBase{
    LoginPage loginPage;
    MainPage mainPage;
    LandingPage landingPage;
    EpisodePage episodePage;
    TimelinePage timelinePage;

    @BeforeClass(alwaysRun = true)
    public void warmUpTest() {
        this.loginPage = new LoginPage(super.driver);
        this.mainPage= new MainPage(super.driver);
        this.landingPage = new LandingPage(super.driver);
        this.episodePage = new EpisodePage(super.driver);
        this.timelinePage = new TimelinePage(super.driver);
        }
    @Test(priority = 0)
    public void goToHafner() throws IOException {
        //loginPage.logInAs39(ConfigProvider.getValidUserName(),ConfigProvider.getValidUserPassword());
        mainPage.clickMenuButton().clickLandingPageButton();
        landingPage.searchPatient();
        RemoteBrowser.implicitWait(5);
        landingPage.selectExactResult();


    }
}
