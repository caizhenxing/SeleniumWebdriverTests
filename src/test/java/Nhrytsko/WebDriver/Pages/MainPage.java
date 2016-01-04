package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageBase {

    //region Fields
    private WebElement menuButton = super.driver.findElement(By.xpath("//a[@class='menu-link ng-binding']"));

    private WebElement landingPageButton = super.driver.findElement(By.xpath("//a[contains(.,'Landing Page')]"));

    private WebElement userButton = super.driver.findElement(By.xpath("//a[@class='ng-binding']"));

    private WebElement logOutButton = super.driver.findElement(By.xpath("//a[contains(.,'                   Logout               ')]"));

    public MainPage(WebDriver driver) {
        super(driver);
    }
    //endregion

    //region Methods
    public boolean menuButtonIsDisplayed(){
        return this.menuButton.isDisplayed();
    }

    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
        RemoteBrowser.waitForElement(menuButton);
        this.menuButton.click();
        return this;
    }

    public LandingPage clickLandingPageButton(){
        this.landingPageButton.click();
        return new LandingPage(RemoteBrowser.webDriverInstance());
    }

    public MainPage clickUserButton(){
        RemoteBrowser.waitForElement(userButton);
        this.userButton.click();
        return this;
    }
    public LoginPage clickLogOut(){
        RemoteBrowser.waitForElement(this.logOutButton);
        this.logOutButton.click();
        return new LoginPage(RemoteBrowser.webDriverInstance());
    }
    //endregion
}
