package ylysov.InteractiveControlsTests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by ylysov on 22.12.2015.
 */
public class BaseForControlsTests {

    PageBase pages;
    WebDriver driver;
    String StartPageURL = "http://spxko7.cgm.ag/helixuicontrols/#";

    @BeforeSuite(alwaysRun = true)
    public void InitializeBrowser(){
        this.driver = RemoteBrowser.getWebDriverInstance();
        this.driver.navigate().to(StartPageURL);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.Quit(this.driver);
    }
}
