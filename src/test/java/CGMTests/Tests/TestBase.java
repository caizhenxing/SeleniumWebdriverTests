package CGMTests.Tests;

import CGMTests.Pages.PageBase;
import WrappedDriver.RemoteBrowser;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        RemoteBrowser.startSeleniumGrid();
    }

    @AfterSuite
    public void classTearDown(){
        PageBase.closeBrowser();
    }
}