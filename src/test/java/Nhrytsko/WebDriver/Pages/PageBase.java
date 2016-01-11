package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RB;
import org.openqa.selenium.WebDriver;

public class PageBase {
    //region Fields

    public WebDriver driver;
    public MainPage mainPage;

    //region Methods

    public static void startBrowser(){
        RB.getInstance().startBrowser();
    }

    public LoginPage goToLoginPage(){
        RB.getInstance().navigate(ConfigProvider.getBaseURL());
        RB.waitForDocumentToBeReady();
        RB.waitForAjax();
        return new LoginPage();
    }

    public LoginPage proceedWithLoginPage(){
        return new LoginPage();
    }

    public MainPage proceedWithMainPage(){
        RB.waitForDocumentToBeReady();
        RB.waitForAjax();
        RB.implicitWait(10);
        return new MainPage();
    }

    public AllFeaturesPage proceedAllFeaturesPage(){
        RB.waitForDocumentToBeReady();
        RB.waitForAjax();
        RB.implicitWait(10);
        return new AllFeaturesPage();
    }
    public LandingPage proceedWithLandingPage(){
        RB.waitForDocumentToBeReady();
        RB.waitForAjax();
        RB.implicitWait(10);
        return new LandingPage();
    }

    public EpisodePage proceedWithEpisodePage(){
        RB.waitForDocumentToBeReady();
        RB.waitForAjax();
        RB.implicitWait(10);
        return new EpisodePage();
    }

    //endregion
}
