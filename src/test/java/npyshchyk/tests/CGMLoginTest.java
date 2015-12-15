package npyshchyk.tests;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import npyshchyk.pages.CGMLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


/**
 * Created by nmyrosh on 14.12.2015.
 */
public class CGMLoginTest extends TestBase{

    public String stringURL = "http://192.168.241.130:8080/shell-his-module/modules/login.html?mainApplicationPath=index.html";
    public static final String correctUserName = "g3his";
    public static final String incorrectUserName = "g3his_";

    PageBase pages;
    WebDriver driver;
    CGMLoginPage loginPage;

    // should be removed
    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        this.driver = RemoteBrowser.getWebDriverInstance();
        this.pages = new PageBase(this.driver);
    }

    // navigation to Log In Page
    @Test
    public void navigateToLoginPage() {
        this.driver.navigate().to(stringURL);

        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed(), "Log In Page is opened!");
    }

    // Log In with invalid credentials
    @Test
    public void loginFailed(){
        this.loginPage = new CGMLoginPage(this.driver);
        CGMLoginPage.login(this.driver,incorrectUserName);

        Assert.assertTrue(driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed(), "Log In is incorrect! Test is passed!!!!!!!!");
    }

    // Log In with valid credentials
    @Test
    public void successfulLogin(){
        CGMLoginPage.login(this.driver,correctUserName);

        Assert.assertTrue(!driver.findElement(By.xpath("//button[@type='submit']")).isDisplayed(), "Test is passed!!!!!!!!");
    }

    // should be removed
    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.Quit(this.driver);
    }
}
