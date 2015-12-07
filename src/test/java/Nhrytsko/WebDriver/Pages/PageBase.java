package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;

public class PageBase {
    //region Fields
    private static final String mainPageUrl = "http://prometheus.org.ua/";
    WebDriver driver;
    private MainPage mainPage;
    //endregion

    //region Constructors
    public PageBase(){
        this.driver = RemoteBrowser.startWebDriver();
        this.mainPage = new MainPage(this.driver);
    }
    //endregion

    //region Methods

    public MainPage goToMainPage(){
        this.driver.navigate().to(mainPageUrl);
        return new MainPage(this.driver);
    }

    public void CloseBrowser(){
        RemoteBrowser.Quit(this.driver);
    }

    //endregion
}
