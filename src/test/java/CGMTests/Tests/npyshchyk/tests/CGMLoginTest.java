package CGMTests.Tests.npyshchyk.tests;

import CGMTests.Pages.LoginPage;
import CGMTests.Pages.PageBase;
import CGMTests.Tests.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CGMLoginTest extends TestBase{

    LoginPage loginPage;
    WebDriver driver;

    @BeforeClass
    @Parameters(value = {"hub", "browserName"})
    public void classSetUp(String hub, String browserName){
        this.loginPage = PageBase.startBrowser(hub,browserName).goToLoginPage();
    }

    @Test
    public void navigateToLoginPage() {
        Assert.assertTrue(this.loginPage.returnLoginButton().isDisplayed(), "Log In Page is opened!");
    }
}
