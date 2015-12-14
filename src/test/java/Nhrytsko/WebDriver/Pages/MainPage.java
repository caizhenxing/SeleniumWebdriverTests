package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends PageBase {

    @FindBy(xpath = "//*[@id=\'menu-main-menu-1\']/li[7]/a")
    @CacheLookup
    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void ClickSignInButton(){
        this.signInButton.click();
    }

    public String getMainPageTitle(){
        return driver.getTitle();
    }

}
