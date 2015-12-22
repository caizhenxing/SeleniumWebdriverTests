package ovol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ovol.Wrapper.BrowserUsage;

/**
 * Created by ovo on 22.12.2015.
 */
public class MainPage extends StartPage {
    private WebDriver driver;

    @FindBy (xpath = "//img[contains(@class,'ng-scope')]")
    @CacheLookup
    private  static WebElement cgmLogo;

    @FindBy (xpath = "//a[contains(.,'Menu')]")
    @CacheLookup
    private static WebElement menuButton;

    @FindBy(xpath = "//a[contains(.,'Landing Page')]")
    @CacheLookup
    private static WebElement landingPage;

    public MainPage(){
        this.driver = super.driver;
    }

    public static void clickMenuButton() {
        if (cgmLogo == null) {
            System.out.println("You aren't logged in!!!");
        }else{
            BrowserUsage.driverElementWaiter(menuButton);
            menuButton.click();
        }


    }

    public MainPage clickLandingPage(){
        BrowserUsage.driverElementWaiter(landingPage);
        landingPage.click();
        return this;
    }
}
