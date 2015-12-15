package ylysov.CGMAutomationFramework;

/**
 * Created by ylysov on 11.12.2015.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import ylysov.CGMTests.LoginTests;

public class PageBase {


    //region Fields
    private static final String loginPageUrl = "http://192.168.240.39:8080/shell-his-module/modules/login.html";
    WebDriver driver;
    private LoginPage loginPage;
    //endregion

    //region Constructors
    public PageBase(WebDriver driver){
        {
            this.driver = driver;
        }
    }
    //endregion

    //region Methods

    public LoginPage goToLoginPage(){
        this.driver.navigate().to(loginPageUrl);
        return new LoginPage(this.driver);
    }

    public Boolean isAtMainPage(){
        String mainPageTitle = driver.getTitle();
        if (mainPageTitle.contains("CGM G3 - Clinical Information System"));
        return true;
    }

    public MainPage login() {

        String ValidEmailValue = "g3his";
        String ValidPasswordValue = "g3his";

        goToLoginPage().fillEmail(ValidEmailValue).fillPassword(ValidPasswordValue).login();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='menu-link ng-binding']")));

        return new MainPage(this.driver);
    }

    public MainPage goToLandingPage(){
        MainPage obj = new MainPage(driver);
        obj.clickMenu().clickLandingPage();
        return new MainPage(this.driver);
    }

    public LandingPage goToEpisodePage(){
        String patientName = "Hauser Susi";
        LandingPage obj2 = new LandingPage(driver);
        obj2.enterEpisode(patientName);
        return new LandingPage(this.driver);
    }

//    public TimelinePage goToTimelinePage(){
//
//        goToEpisodePage().selectTimelineTab();
//
//        return new TimelinePage(this.driver);
//    }


    public void CloseBrowser(){
        BrowserDriver.Quit(this.driver);
    }

    //endregion
}

