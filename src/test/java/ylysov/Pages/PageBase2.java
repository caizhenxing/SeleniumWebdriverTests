package ylysov.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class PageBase2 {
    //region Fields

    public WebDriver driver;
    public MainPage mainPage;

    //region Constructors

    public PageBase2(WebDriver driver) {
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

    public LoginPage goToLoginPage(){
        try {
            this.driver.navigate().to(ConfigProvider.getBaseURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LoginPage(driver);
    }

    //endregion
}
