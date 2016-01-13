package ylysov.CGMTests;

import Nhrytsko.WebDriver.Pages.LandingPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase2 {

    public MainPage mainPage;
    public LandingPage landingPage;

    PageBase pages;
    WebDriver driver;
    String StartPageURL = "http://192.168.240.39:8080/shell-his-module/modules/login.html";

    @BeforeSuite(alwaysRun = true)
    public  void InitializeBrowser(){
        this.driver.navigate().to(StartPageURL);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        RemoteBrowser.quit();
    }
}


