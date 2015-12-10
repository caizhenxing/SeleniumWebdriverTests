package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageBase {

    private WebElement signInButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getSignInButton(){
        signInButton= this.driver.findElement(By.xpath("//*[@id=\'menu-main-menu-1\']/li[7]/a"));
        return this.signInButton;
    }

    public void ClickSignInButton(){
        getSignInButton().click();
    }

    public String getMainPageTitle(){
        return driver.getTitle();
    }

}
