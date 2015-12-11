package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    PageBase pages;
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        this.driver = RemoteBrowser.getWebDriverInstance();
        this.pages = new PageBase(this.driver);
    }

    @AfterSuite
    public void tearDown(){
        RemoteBrowser.Quit(this.driver);
    }
}
