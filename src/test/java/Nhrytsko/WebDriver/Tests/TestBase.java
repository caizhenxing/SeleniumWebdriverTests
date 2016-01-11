package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public PageBase pages;
    public WebDriver driver;
    public RemoteBrowser instance;
    public LoginPage loginPage;

    @BeforeSuite (alwaysRun = true)
    public void setUp(){
        PageBase.startBrowser();
        this.pages = new PageBase();
        this.pages.goToLoginPage();
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.getInstance().quit();
    }
}
