package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NavigationTests {

    PageBase page;

    @BeforeSuite
    public void setUp(){
        this.page = new PageBase();
    }

    @Test
    public void NavigateToMainPage(){
        String title = this.page.goToMainPage().getMainPageTitle();

        Assert.assertEquals(title, "Prometheus – масові безкоштовні онлайн-курси", "Page titles are not equal");

    }

    @Test
    public void ClickSignInLink(){
    }

    @AfterSuite
    public void tearDown(){
        this.page.CloseBrowser();
    }
}
