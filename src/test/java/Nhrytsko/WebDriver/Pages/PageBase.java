package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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
        MainPage mainPage = PageFactory.initElements(this.driver, MainPage.class);
        return mainPage;
    }

    //endregion
}
