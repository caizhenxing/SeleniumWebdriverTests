package Nhrytsko.WebDriver;

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

    public void ClickSignInButton(WebDriver driver){
        signInButton = driver.findElement(By.className(signInButtonLink));
        signInButton.click();
    }

    public String getMainPageTitle(){
        String title = driver.getTitle();
        return title;
    }

}
