package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        ConfigProvider.setChromeDriverPath();
        ConfigProvider.setIEDriverPath();
        RemoteBrowser.getInstance().startSeleniumGrid();
    }

    @AfterClass
    public void classTearDown(){
        PageBase.closeBrowser();
    }
}