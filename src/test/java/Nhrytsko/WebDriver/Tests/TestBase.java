package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
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
