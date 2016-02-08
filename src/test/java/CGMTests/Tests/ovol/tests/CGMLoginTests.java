
package CGMTests.Tests.ovol.tests;
//

import CGMTests.Pages.LoginPage;
import CGMTests.Pages.MainPage;
import CGMTests.Pages.WebPageBase;
import CGMTests.Tests.TestBase;
import WrappedDriver.ConfigProvider;
import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;



// * Created by ovo on 22.12.2015.


public class CGMLoginTests extends TestBase {
    WebPageBase pages;
    MainPage mainPage;
    LoginPage loginPage;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement logLogo;


    @BeforeClass(alwaysRun = true)
    public void warmUp() {
        this.loginPage = new LoginPage();
        this.mainPage = this.loginPage.logInAs(ConfigProvider.getValidUserName(), ConfigProvider.getValidUserPassword())
                .proceedWithMainPage();

    }

    @Test(priority = 0)
    public void tryToValidLogin() throws IOException {
       RemoteBrowser.waitForAjax();
       mainPage.clickUserButton();
       mainPage.clickLogOut();

    }
    @Test(priority = 1)
    public void tryToInvalidLogin() throws IOException, InterruptedException {
        loginPage.logInAs(ConfigProvider.getInvalidUserName(), ConfigProvider.getInvalidUserPassword());
        RemoteBrowser.waitForAjax();
        String warningMessage =this.loginPage.getWarningMessage();
        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Message isn't displayed");


    }



}
