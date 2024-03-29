package CGMTests.Tests.nhrytsko.tests;

import CGMTests.Pages.LoginPage;
import CGMTests.Pages.WebPageBase;
import CGMTests.Tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTestSuite extends TestBase {

    LoginPage loginPage;
    String browserName;

    @DataProvider(name = "data-provider")
    public Object [] [] data(){
        return new Object[][]{
                {"g2his", "g3his"},
                {"g3his","g2his"}
        };
    }

    @BeforeClass
    @Parameters(value = {"hub", "driverName", "port"})
    public void classSetUp(String hub, String browserName, String port){
        this.loginPage = WebPageBase.startBrowser(hub, browserName, port).goToStartPage();
        this.browserName = browserName;
    }

    @Test (groups = {"group2"}, dataProvider = "data-provider")
    public void userCannotLogInWithInvalidCredentials(String userName, String userPassword) {
        this.loginPage.logInAs(userName, userPassword);

        String warningMessage = this.loginPage.getWarningMessage();

        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Messages are not equal");
        System.out.println("Test is running the thread #"+Thread.currentThread().getId() + " in browser " + this.browserName);
    }
}
