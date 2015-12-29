package ovol.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Tests.TestBase;
import org.testng.annotations.BeforeClass;

/**
 * Created by ovo on 28.12.2015.
 */
public class FastSearchTests extends TestBase{
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeClass(alwaysRun = true)
    public void warmUpTest() {
        this.loginPage = new LoginPage(super.driver);


    }
}
