package ylysov.Pages;

import Nhrytsko.WebDriver.Pages.LandingPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ylysov.grid1.WebDriverFactory;

public class MainPage extends PageBase {

    //region Fields
    @FindBy(xpath = "//a[@class='menu-link ng-binding']")
    @CacheLookup
    private WebElement menuButton;

    @FindBy(xpath = "//a[contains(.,'Landing Page')]")
    @CacheLookup
    private WebElement landingPageButton;

    @FindBy(xpath = "//a[@class='ng-binding']")
    @CacheLookup
    private WebElement userButton;

    @FindBy(xpath = ("//a[contains(.,'                   Logout               ')]"))
    @CacheLookup
    private WebElement logOutButton;

    //endregion

    //region Methods
    public boolean menuButtonIsDisplayed(){
        return this.menuButton.isDisplayed();
    }

    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
        WebDriverFactory.waitForElement(menuButton);
        this.menuButton.click();
        return this;
    }

    public LandingPage clickLandingPageButton(){
        this.landingPageButton.click();
        return new LandingPage();
    }

    public MainPage clickUserButton(){
        WebDriverFactory.waitForElement(userButton);
        this.userButton.click();
        return this;
    }
    public LoginPage clickLogOut(){
        WebDriverFactory.waitForElement(this.logOutButton);
        this.logOutButton.click();
        return new LoginPage();
    }
    //endregion
}
