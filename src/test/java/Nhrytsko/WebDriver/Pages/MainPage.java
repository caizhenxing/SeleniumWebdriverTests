package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/hx-feature-view-port/div/cgm-shell/div/cgm-shell-main-menu/div[1]/ul[1]/li/a")
    @CacheLookup
    private WebElement menuButton;

    @FindBy(xpath = "/html/body/hx-feature-view-port/div/cgm-shell/div/cgm-shell-main-menu/div[1]/ul[1]/li/div/a")
    @CacheLookup
    private WebElement allFeatures;

    public MainPage(){
        this.driver = super.driver;
    }

    public void clickMenuButton(){
        this.menuButton.click();
    }

    public void selectAllFeatures() {
        this.allFeatures.click();
    }
}
