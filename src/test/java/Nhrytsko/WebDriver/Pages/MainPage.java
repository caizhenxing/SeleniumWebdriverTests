package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Button;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Link;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SelectorConverter;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageBase {

    //region Fields
    private WebElement menuButton = new Button(SearchCriteria.Xpath, "//a[contains(.,'Menu')]");

    private WebElement userButton = new Button(SearchCriteria.Xpath,"//a[@class='ng-binding']");

    //private

    public MainPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region Methods
    public boolean menuButtonIsDisplayed(){
        return this.menuButton.isDisplayed();
    }

    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
        this.menuButton.click();
        return this;
    }

    public MainPage clickUserButton(){
        this.userButton.click();
        return this;
    }
    public LoginPage clickLogOut(){
        WebElement logOutButton = new Button(SearchCriteria.Xpath,"//a[contains(.,'                   Logout               ')]");
        logOutButton.click();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }
    //endregion
}
