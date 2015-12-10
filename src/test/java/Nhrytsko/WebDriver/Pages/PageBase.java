package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.WebDriver;

public class PageBase {
    //region Fields

    private static final String mainPageUrl = "http://prometheus.org.ua/";
    WebDriver driver;

    //endregion

    //region Constructors
    public PageBase(WebDriver driver) {
        this.driver = driver;
    }
    //endregion

    //region Methods

    public MainPage goToMainPage(){
        this.driver.navigate().to(mainPageUrl);
        return new MainPage(this.driver);
    }

    //endregion
}
