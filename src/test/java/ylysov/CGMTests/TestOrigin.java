package ylysov.CGMTests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ylysov.CGMAutomationFramework.PageBase;

/**
 * Created by ylysov on 11.12.2015.
 */
public class TestOrigin {

    PageBase pages;

    @BeforeSuite
    public void setUp(){
        this.pages = new PageBase();
    }

    @AfterSuite
    public void tearDown(){
        this.pages.CloseBrowser();
    }
}

