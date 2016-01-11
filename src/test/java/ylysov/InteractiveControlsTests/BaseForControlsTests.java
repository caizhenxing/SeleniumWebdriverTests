package ylysov.InteractiveControlsTests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RB;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseForControlsTests {

    PageBase pages;
    WebDriver driver;
    String StartPageURL = "http://spxko7.cgm.ag/helixuicontrols/#";

    @BeforeSuite(alwaysRun = true)
    public void InitializeBrowser(){
        this.driver.navigate().to(StartPageURL);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        RB.getInstance().quit();
    }
}
