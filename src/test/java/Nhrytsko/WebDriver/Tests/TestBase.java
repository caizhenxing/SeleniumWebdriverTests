package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LandingPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

public class TestBase {
    PageBase pages;
    WebDriver driver;
    public MainPage mainPage;
    LandingPage landingPage;

    @BeforeSuite (alwaysRun = true)
    public void setUp(){
        this.driver = RemoteBrowser.getWebDriverInstance();
        this.pages = new PageBase(this.driver);
        try {
            this.mainPage = this.pages.logInAs(ConfigProvider.getUserName(), ConfigProvider.getUserPassword());
        } catch (IOException e) {
            e.printStackTrace();
        }
        RemoteBrowser.implicitWait(10);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.Quit(this.driver);
    }
}
