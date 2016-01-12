package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestSuite extends TestBase {

    PageBase pages;
    LoginPage loginPage;

    @DataProvider(name = "data-provider", parallel = false)
    public Object [] [] data(){
        return new Object[][]{
                {"g2his", "g3his"},
                {"g3his","g2his"}
        };
    }

    @BeforeClass
    @Parameters(value = {"hub", "browserName"})
    public void testClassSetup(String hub, String browserName){
        PageBase.startBrowser(hub, browserName);
        this.pages = new PageBase();
        this.pages.goToLoginPage();
        this.loginPage = new LoginPage();
    }

    @Test (groups = {"group2"}, dataProvider = "data-provider")
    public void userCannotLogInWithInvalidCredentials(String userName, String userPassword) {
            this.loginPage.logInAs(userName, userPassword);

        String warningMessage = this.loginPage.getWarningMessage();

        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Messages are not equal");
    }
}
