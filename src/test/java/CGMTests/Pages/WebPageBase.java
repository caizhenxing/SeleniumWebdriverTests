package CGMTests.Pages;

import WrappedDriver.ConfigProvider;
import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;

public class WebPageBase {
    //region Fields

    public WebDriver driver;
    public MainPage mainPage;

    //region Methods

    public static WebPageBase startBrowser(String hub, String browserName, String port){
        RemoteBrowser.getInstance().startBrowser(hub, browserName, port);
        return new WebPageBase();
    }

    public static void closeBrowser(){
        RemoteBrowser.getInstance().quit();
    }

    public LoginPage goToStartPage(){
        RemoteBrowser.getInstance().navigate(ConfigProvider.getBaseURL());
        RemoteBrowser.getInstance().waitForDocumentToBeReady();
        RemoteBrowser.getInstance().waitForAjax();
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
