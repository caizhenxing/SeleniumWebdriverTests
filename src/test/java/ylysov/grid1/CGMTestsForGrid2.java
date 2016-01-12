package ylysov.grid1;
import ylysov.Pages.LoginPage;
import ylysov.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.Test;


public class CGMTestsForGrid2 extends TestBaseForGrid {

    LoginPage loginPage;
    MainPage mainPage;

    @Test
    public void t1LogIn() {

        this.loginPage = new LoginPage(driver); //!!!!!!!

        loginPage.enterUserName(ConfigProvider.getValidUserName());


              loginPage.enterUserPassword(ConfigProvider.getValidUserPassword());
              loginPage.clickLoginButton();
           }

                @Test
            public void t2NavigateToLandingPage() {
                   this.mainPage = new MainPage(driver);
                  mainPage.clickMenuButton();
                  mainPage.clickLandingPageButton();
               }
       }
