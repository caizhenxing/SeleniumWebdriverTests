package ylysov.CGMAutomationFramework;

/**
 * Created by ylysov on 11.12.2015.
 */

import org.openqa.selenium.WebDriver;
import ylysov.CGMTests.LoginTests;

public class PageBase {


    //region Fields
    private static final String loginPageUrl = "http://192.168.240.39:8080/shell-his-module/modules/login.html";
    WebDriver driver;
    private LoginPage loginPage;
    //endregion

    //region Constructors
    public PageBase(){
        this.driver = BrowserDriver.startWebDriver();
    }
    //endregion

    //region Methods

    public LoginPage goToLoginPage(){
        this.driver.navigate().to(loginPageUrl);
        return new LoginPage(this.driver);
    }

    public Boolean isAtMainPage(){
        String mainPageTitle = driver.getTitle();
        if (mainPageTitle.contains("CGM G3 - Clinical Information System"));
        return true;

    }

    public LandingPage goToLandingPage(){
        LoginTests login = new LoginTests();
        login.loginWithValidCredentials();
        return new LandingPage(this.driver);
    }

    public EpisodePage goToEpisodePage(){
        String patientName = "Hauser Susi";
        goToLandingPage().enterEpisode(patientName);
        return new EpisodePage(this.driver);
    }

    public TimelinePage goToTimelinePage(){

        goToEpisodePage().selectTimelineTab();

        return new TimelinePage(this.driver);
    }


    public void CloseBrowser(){
        BrowserDriver.Quit(this.driver);
    }

    //endregion
}

