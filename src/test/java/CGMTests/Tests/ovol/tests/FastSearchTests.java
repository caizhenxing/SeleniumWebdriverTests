package CGMTests.Tests.ovol.tests;

import CGMTests.Pages.*;
import CGMTests.Pages.WebPageBase;
import CGMTests.Tests.TestBase;
import WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class FastSearchTests extends TestBase{
    WebPageBase pageBase;
    LoginPage loginPage;
    MainPage mainPage;
    AllFeaturesPage allFeaturesPage;
    LandingPage landingPage;
    EpisodePage episodePage;
    TimelinePage timelinePage;

    @BeforeClass(alwaysRun = true)
    public void warmUpTest() throws IOException {
        this.loginPage = new LoginPage();
        this.mainPage = this.loginPage.logInAs(ConfigProvider.getValidUserName(),ConfigProvider.getValidUserPassword())
                .proceedWithMainPage();
        this.allFeaturesPage = this.mainPage.clickMenuButton().clickAllFeaturesButton().proceedAllFeaturesPage();
        this.landingPage = this.allFeaturesPage.clickLandingPageButton().proceedWithLandingPage();
       // this.episodePage = this.landingPage.searchPatient().selectExactResult().proceedWithEpisodePage();

        }
    @Test(priority = 0)
    public void goToHafner() throws IOException {
        Assert.assertTrue(landingPage.labelEpisodeIsDisplayed(), "Not displayed");


    }
}
