package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PageBase {
    //region Fields

    public WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;
    LandingPage landingPage;

    //endregion

    //region Constructors
    public PageBase() {}

    public PageBase(WebDriver driver) {
        this.driver = driver;
    }

    //endregion

    //region Methods

    public MainPage logInAs(String userName, String password){

        goToLoginPage()
                .enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();
        this.mainPage = new MainPage();
                PageFactory.initElements(this.driver, mainPage);
        return mainPage;
    }

    private LoginPage goToLoginPage(){
        try {
            this.driver.navigate().to(ConfigProvider.getBaseURL());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.loginPage = new LoginPage();
        PageFactory.initElements(this.driver, loginPage);
        return loginPage;
    }

    public MainPage goToLandingPage(){
        this.mainPage = new MainPage();
        PageFactory.initElements(this.driver, mainPage);
        mainPage.clickMenuButton();
        mainPage.clickLandingPageButton();
        return mainPage;
    }

    public LandingPage goToEpisodePage(String patientName) throws InterruptedException{
        this.landingPage = new LandingPage();
        PageFactory.initElements(this.driver, landingPage);
        landingPage.enterEpisode(patientName);
        landingPage.selectTopSearchResult();
//        landingPage.selectRandomSearchResult();
        return landingPage;
    }

    public LandingPage InitializeLandingPage(){
        this.landingPage = new LandingPage();
        PageFactory.initElements(this.driver, landingPage);
        return landingPage;
    }



    //endregion
}
