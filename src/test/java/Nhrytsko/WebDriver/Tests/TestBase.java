package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.LoginPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    public LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        ConfigProvider.setChromeDriverPath();
        ConfigProvider.setIEDriverPath();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.quit();
    }
}
