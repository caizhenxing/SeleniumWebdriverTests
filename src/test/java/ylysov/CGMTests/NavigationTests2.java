package ylysov.CGMTests;

import Nhrytsko.WebDriver.Pages.*;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ylysov on 16.12.2015.
 */
public class NavigationTests2 extends TestBase2 {

    LoginPage loginPage;
    MainPage mainPage;
    LandingPage landingPage;
    EpisodePage episodePage;
    TimelinePage timelinePage;

    @Test
    public void t1LogIn() {
        this.loginPage = new LoginPage(driver);  //!!!!!!!
        loginPage.enterUserName(ConfigProvider.getValidUserName());
        loginPage.enterUserPassword(ConfigProvider.getValidUserPassword());
        loginPage.clickLoginButton();
       }

    @Test
    public void t2NavigateToLandingPage() {
        this.mainPage = new MainPage(driver);
        mainPage.clickMenuButton();
        mainPage.clickLandingPageButton();
    }


    @Test
    public void t3NavigateToEpisodePage() {
        this.landingPage = new LandingPage(driver);
        landingPage.enterEpisode(ConfigProvider.getPatientName());
        landingPage.selectTopSearchResult();
    }

    @Test
    public void t4NavigateToTimelinePage() {
        this.episodePage = new EpisodePage(driver);
        episodePage.selectTimelineTab();
    }

    @Test
    public void t5OnTimelinePage() {
        this.timelinePage = new TimelinePage(driver);
        timelinePage.clickMedicationsButton();
        timelinePage.clickAddNewMedication();
        timelinePage.selectStandardMedication();
    }
}

