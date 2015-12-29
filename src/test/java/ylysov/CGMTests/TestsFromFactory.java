package ylysov.CGMTests;

import ylysov.Pages.LoginPage;
import ylysov.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by ylysov on 29.12.2015.
 */
public class TestsFromFactory extends TestBaseFactory{
    LoginPage loginPage;
    MainPage mainPage;


    @Test
    public void t1LogIn() {
        this.loginPage = new LoginPage(driver);  //!!!!!!!
//        try {
            loginPage.enterUserName(ConfigProvider.getValidUserName());
            loginPage.enterUserPassword(ConfigProvider.getValidUserPassword());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        loginPage.clickLoginButton();
    }

    @Test
    public void t2NavigateToLandingPage() {
        this.mainPage = new MainPage(driver);
        mainPage.clickMenuButton();
        mainPage.clickLandingPageButton();
    }






}
