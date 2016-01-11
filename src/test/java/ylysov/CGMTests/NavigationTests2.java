package ylysov.CGMTests;

import Nhrytsko.WebDriver.Pages.*;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.Test;

public class NavigationTests2 extends TestBase2 {

    LoginPage loginPage;
    MainPage mainPage;
    LandingPage landingPage;
    EpisodePage episodePage;
    TimelinePage timelinePage;

    @Test
    public void t1LogIn() {
        this.loginPage = new LoginPage();  //!!!!!!!
        loginPage.enterUserName(ConfigProvider.getValidUserName());
        loginPage.enterUserPassword(ConfigProvider.getValidUserPassword());
        loginPage.clickLoginButton();
       }

    @Test
    public void t2NavigateToLandingPage() {
        this.mainPage = new MainPage();
        mainPage.clickMenuButton();
        //mainPage.clickLandingPageButton();
    }


    @Test
    public void t3NavigateToEpisodePage() {
        this.landingPage = new LandingPage();
        landingPage.enterEpisode(ConfigProvider.getPatientName());
        landingPage.selectTopSearchResult();
    }

    @Test
    public void t4NavigateToTimelinePage() {
        this.episodePage = new EpisodePage();
        episodePage.selectTimelineTab();
    }

    @Test
    public void t5OnTimelinePage() {
        this.timelinePage = new TimelinePage();
        timelinePage.clickMedicationsButton();
        timelinePage.clickAddNewMedication();
        timelinePage.selectStandardMedication();
    }
}

