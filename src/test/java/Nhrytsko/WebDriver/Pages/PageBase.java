package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;

public class PageBase {
    //region Fields

    public WebDriver driver;
    public MainPage mainPage;

    //region Methods

    public static void startBrowser(String hub, String browserName){
        RemoteBrowser.getInstance().startBrowser(hub, browserName);
    }

    public LoginPage goToLoginPage(){
        RemoteBrowser.getInstance().navigate(ConfigProvider.getBaseURL());
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        return new LoginPage();
    }

    public LoginPage proceedWithLoginPage(){
        return new LoginPage();
    }

    public MainPage proceedWithMainPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new MainPage();
    }

    public AllFeaturesPage proceedAllFeaturesPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new AllFeaturesPage();
    }
    public LandingPage proceedWithLandingPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new LandingPage();
    }

    public EpisodePage proceedWithEpisodePage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new EpisodePage();
    }

    //endregion
}
