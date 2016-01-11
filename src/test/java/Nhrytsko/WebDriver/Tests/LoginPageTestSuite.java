package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTestSuite extends TestBase {

    MainPage mainPage;
    LoginPage loginPage;

    @DataProvider(name = "data-provider", parallel = false)
    public Object [] [] data(){
        return new Object[][]{
                {"g2his", "g3his"},
                {"g3his","g2his"}
        };
    }

    @BeforeClass
    public void testClassSetup(){
        this.loginPage = new LoginPage();
    }

    @Test (groups = {"group2"}, dataProvider = "data-provider")
    public void userCannotLogInWithInvalidCredentials(String userName, String userPassword) {
            this.loginPage.logInAs(userName, userPassword);

        String warningMessage = this.loginPage.getWarningMessage();

        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Messages are not equal");
    }
}
