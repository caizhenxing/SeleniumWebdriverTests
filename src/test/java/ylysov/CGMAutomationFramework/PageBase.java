package ylysov.CGMAutomationFramework;

/**
 * Created by ylysov on 11.12.2015.
 */

import org.openqa.selenium.WebDriver;


public class PageBase {
    //region Fields
    private static final String loginPageUrl = "http://192.168.240.39:8080/shell-his-module/modules/login.html";
    WebDriver driver;
    private LoginPage loginPage;
    //endregion

    //region Constructors
    public PageBase(){
        this.driver = BrowserDriver.startWebDriver();
        this.loginPage = new LoginPage(this.driver);
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

    public void CloseBrowser(){
        BrowserDriver.Quit(this.driver);
    }

    //endregion
}

