package ovol.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.io.IOException;

/**
 * Created by ovo on 22.12.2015.
 */
public class CGMLoginTests extends TestBase{
    PageBase pages;
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;

    @FindBy (xpath = ("//button[@type='submit']"))
    @CacheLookup
    private WebElement logLogo;

    @BeforeSuite
    public void setUp() {
        this.driver = RemoteBrowser.getWebDriverInstance();
        this.pages = new PageBase(this.driver);

    }
    @Test
    public void goToPage(){
        pages.goToLoginPage();
        RemoteBrowser.implicitWait(10);
    }
    @Test
    public void tryToValidLogin() throws IOException {
        pages.logInAs(ConfigProvider.getUserName(), ConfigProvider.getUserPassword());
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.Quit(this.driver);
    }

}
