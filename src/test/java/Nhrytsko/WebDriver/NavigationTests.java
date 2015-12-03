package Nhrytsko.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NavigationTests {

    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = new FirefoxDriver();
    }

    @Test
    public void NavigateToMainPage(){

        String pageTitle= PageNavigation.goToMainPage(driver).getMainPageTitle();

        Assert.assertEquals(pageTitle, "Prometheus – масові безкоштовні онлайн-курси");
    }

    @Test
    public void ClickSignInLink(){

        PageNavigation.goToMainPage(driver).ClickSignInButton(driver);
    }

    @AfterSuite
    public void tearDown(){
        PageNavigation.tearDown(driver);
    }
}
