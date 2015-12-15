package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class PageBase {
    //region Fields

    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

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

   /* public void waiForElementToBeReady(){
        this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }*/

    //endregion
}
