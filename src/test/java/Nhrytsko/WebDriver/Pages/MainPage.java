package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    private WebDriver driver;

    @FindBy(xpath = "//a[@class='menu-link ng-binding']")
    @CacheLookup
    private WebElement menuButton;

    @FindBy(xpath = "//a[@class='menu-item ng-binding ng-scope cgm-truncation']")
    @CacheLookup
    private WebElement landingPageButton;

    @FindBy(xpath = "//a[@class='ng-binding']")
    @CacheLookup
    private WebElement userButton;

    @FindBy(xpath = ("//a[contains(.,'                   Logout               ')]"))
    @CacheLookup
    private WebElement toLogOut;

    public MainPage(){
        this.driver = super.driver;
    }

    public void clickMenuButton(){
        this.menuButton.click();
    }

    public void clickLandingPageButton(){
        this.landingPageButton.click();
    }
    public void clickUserButton(){
        RemoteBrowser.waitForElement(userButton);
        this.userButton.click();
    }
    public void clickLogOut(){
        RemoteBrowser.waitForElement(toLogOut);
        this.toLogOut.click();
    }

}
