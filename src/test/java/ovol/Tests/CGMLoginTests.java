
package ovol.Tests;
//

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;



// * Created by ovo on 22.12.2015.


public class CGMLoginTests extends TestBase {
    PageBase pages;
    MainPage mainPage;
    LoginPage loginPage;

    @FindBy(xpath = "//button[@type='submit']")
    @CacheLookup
    private WebElement logLogo;


    @BeforeClass(alwaysRun = true)
    public void warmUp() {
        this.loginPage = new LoginPage(super.driver);
        this.mainPage = new MainPage(super.driver);

    }

    @Test(priority = 0)
    public void tryToValidLogin() throws IOException {
       //super.pages.logInAs39(ConfigProvider.getValidUserName(), ConfigProvider.getValidUserPassword());
       mainPage.clickUserButton();
       //mainPage.clickLogOut();

    }
    @Test(priority = 1)
    public void tryToInvalidLogin() throws IOException, InterruptedException {
        //super.pages.logInAs39(ConfigProvider.getInvalidUserName(), ConfigProvider.getInvalidUserPassword());
        String warningMessage =this.loginPage.getWarningMessage();
        Assert.assertEquals(warningMessage, "Login failed - Invalid user name or bad password.", "Message isn't displayed");


    }



}
