package ovol.Tests;

import Nhrytsko.WebDriver.Pages.*;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ovo on 28.12.2015.
 */
public class FastSearchTests extends TestBase{
    PageBase pageBase;
    LoginPage loginPage;
    MainPage mainPage;
    AllFeaturesPage allFeaturesPage;
    LandingPage landingPage;
    EpisodePage episodePage;
    TimelinePage timelinePage;

    @BeforeClass(alwaysRun = true)
    public void warmUpTest() throws IOException {
        this.loginPage = new LoginPage(super.driver);
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
