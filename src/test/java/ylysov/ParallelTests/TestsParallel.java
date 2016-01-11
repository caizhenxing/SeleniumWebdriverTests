package ylysov.ParallelTests;

import ylysov.Pages.LoginPage;
import ylysov.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.Test;


public class TestsParallel extends TestBaseForParallel {
    LoginPage loginPage;
    MainPage mainPage;


    @Test
    public void t1LogIn() {
        this.loginPage = new LoginPage();  //!!!!!!!
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
        this.mainPage = new MainPage();
        mainPage.clickMenuButton();
        mainPage.clickLandingPageButton();
    }






}
