package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    WebDriver driver;
    WebElement signInButton;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

    private final String signInButtonLink = "icon-signin";

    public void ClickSignInButton(){
        signInButton = this.driver.findElement(By.className(signInButtonLink));
        signInButton.click();
    }

    public String getMainPageTitle(){
        return driver.getTitle();
    }

}
