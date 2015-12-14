package ylysov.CGMTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ylysov.CGMAutomationFramework.BrowserDriver;
import ylysov.CGMAutomationFramework.PageBase;

/**
 * Created by ylysov on 11.12.2015.
 */
public class TestOrigin {

    PageBase pages;
    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        this.driver = BrowserDriver.getWebDriverInstance();
        this.pages = new PageBase(this.driver);
    }

    @AfterSuite
    public void tearDown(){
        this.pages.CloseBrowser();
    }
}

