package ylysov.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ylysov.grid1.WebDriverFactory;

public class MainPage extends PageBase2 {


    String mainPageURL = "http://192.168.240.39:8080/shell-his-module/modules/index.html#/his/shell/main/default";

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

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    //endregion

    //region Methods
//        public static boolean menuButtonIsDisplayed(){
//            WebElement menuButton = Driver.instance.findElement(By.id("btnLogin"));
//        return menuButton != null;


    public MainPage clickMenuButton(){                       // ylysov  added this method 28.12.2015
       WebDriverFactory.waitForElement(menuButton);
        this.menuButton.click();
        return this;
    }

    public LandingPage clickLandingPageButton(){
        this.landingPageButton.click();
        return new LandingPage(driver);
    }

    public MainPage clickUserButton(){
        WebDriverFactory.waitForElement(userButton);
        this.userButton.click();
        return this;
    }
    public LoginPage clickLogOut(){
        WebDriverFactory.waitForElement(this.logOutButton);
        this.logOutButton.click();
        return new LoginPage(driver);
    }
    //endregion
}
