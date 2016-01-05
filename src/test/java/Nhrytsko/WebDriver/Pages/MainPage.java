package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Button;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region Methods
    public boolean menuButtonIsDisplayed(){
        WebElement menuButton = new Button(SearchCriteria.Xpath, "//a[contains(.,'Menu')]");
        return menuButton.isDisplayed();
    }

    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
        WebElement menuButton = new Button(SearchCriteria.Xpath, "//a[contains(.,'Menu')]");
        menuButton.click();
        return this;
    }

    public AllFeaturesPage clickAllFeaturesButton() {
        WebElement allFeaturesButton = new Button(SearchCriteria.Xpath, "//a[@feature='allFeatures']");
        allFeaturesButton.click();
        return new AllFeaturesPage(super.driver);
    }

    public MainPage clickUserButton(){
        WebElement userButton = new Button(SearchCriteria.Xpath,"//a[@class='ng-binding']");
        userButton.click();
        return this;
    }
    public LoginPage clickLogOut(){
        WebElement logOutButton = new Button(SearchCriteria.Xpath,"//a[contains(.,'                   Logout               ')]");
        logOutButton.click();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }
    //endregion
}
