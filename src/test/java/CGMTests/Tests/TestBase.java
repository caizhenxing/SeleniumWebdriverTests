package CGMTests.Tests;

import CGMTests.Pages.WebPageBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void setUp(){}

    @AfterSuite
    public void classTearDown(){
        WebPageBase.closeBrowser();
    }
}