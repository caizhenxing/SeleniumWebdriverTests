package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;

public class PageBase {
    //region Fields

    public WebDriver driver;
    public MainPage mainPage;

    //region Constructors

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    //endregion

    //region Methods

    public LoginPage goToLoginPage(){
        this.driver.navigate().to(ConfigProvider.getBaseURL());
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }

    public LoginPage proceedWithLoginPage(){
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }

    public MainPage proceedWithMainPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new MainPage(RemoteBrowser.webDriverInstance());
    }

    public AllFeaturesPage proceedAllFeaturesPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new AllFeaturesPage((RemoteBrowser.webDriverInstance()));
    }
    public LandingPage proceedWithLandingPage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new LandingPage((RemoteBrowser.webDriverInstance()));
    }

    public EpisodePage proceedWithEpisodePage(){
        RemoteBrowser.waitForDocumentToBeReady();
        RemoteBrowser.waitForAjax();
        RemoteBrowser.implicitWait(10);
        return new EpisodePage((RemoteBrowser.webDriverInstance()));
    }

    //endregion
}
