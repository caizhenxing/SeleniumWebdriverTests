package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    PageBase pages;
    WebDriver driver;

    LoginPage loginPage;

    @BeforeSuite (alwaysRun = true)
    public void setUp(){
        this.driver = RemoteBrowser.webDriverInstance();
        this.pages = new PageBase(this.driver);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.webDriverInstance().quit();
    }
}
