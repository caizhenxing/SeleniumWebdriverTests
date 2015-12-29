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

    //<editor-fold desc="Valid logging">
    public MainPage logInAs(String userName, String password){
        goToLoginPage()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();
        return this.mainPage;
    }
    public MainPage logInAs39(String userName, String password){
        goToLoginPage39()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();
        return this.mainPage;
    }


    public LoginPage goToLoginPage(){
        this.driver.navigate().to(ConfigProvider.getBaseURL());
        RemoteBrowser.waitForDocumentToBeReady();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }

    public LoginPage goToLoginPage39(){
        this.driver.navigate().to(ConfigProvider.getPageUrl());
        RemoteBrowser.waitForDocumentToBeReady();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }

    //endregion
}
