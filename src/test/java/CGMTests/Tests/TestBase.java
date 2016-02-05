package CGMTests.Tests;

import CGMTests.Pages.PageBase;
import WrappedDriver.ConfigProvider;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        ConfigProvider.setChromeDriverPath();
        ConfigProvider.setIEDriverPath();
    }

    @AfterSuite
    public void classTearDown(){
        PageBase.closeBrowser();
    }
}