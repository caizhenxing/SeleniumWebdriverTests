package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

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
        return new LoginPage(this.driver);
    }

    public MainPage proceedWithMainPage(){
        return new MainPage(this.driver);
    }

    //endregion
}
