package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBase {

    private WebElement userName = super.driver.findElement(By.xpath("//input[@ng-model='loginData.userName']"));

    private WebElement userPassword = super.driver.findElement(By.xpath("//input[@cgm-label='Password']"));

    private WebElement loginButton = super.driver.findElement(By.id("btnLogin"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public PageBase logInAs(String userName, String password){
                enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();
        return new PageBase(super.driver);
    }

    //region Methods
    public LoginPage enterUserName(String userName) {
        RemoteBrowser.waitForAjax();
        RemoteBrowser.waitForElement(this.userName);
        this.userName.click();
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String userPassword) {
        RemoteBrowser.waitForAjax();
        RemoteBrowser.waitForElement(this.userPassword);
        this.userPassword.click();
        this.userPassword.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton() {
        this.loginButton.click();
        return this;
    }

    public boolean logInButtonIsDisplayed() {
        RemoteBrowser.waitForElement(this.loginButton);
        return this.loginButton.isDisplayed();
    }

    public String getWarningMessage(){
        RemoteBrowser.waitForAjax();
        WebElement warningMessage = super.driver.findElement(By.xpath("//div[@class='message-text ng-binding']"));
        RemoteBrowser.waitForElement(warningMessage);

        return warningMessage.getText();
    }

//endregion
}