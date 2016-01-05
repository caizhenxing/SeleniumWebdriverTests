package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Button;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Input;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    private WebElement userName = new Input(SearchCriteria.Xpath, "//input[@ng-model='loginData.userName']");

    private WebElement userPassword = new Input(SearchCriteria.Xpath, "//input[@cgm-label='Password']");

    private WebElement loginButton = new Button(SearchCriteria.Id, "btnLogin");

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
        this.userName.clear();
        this.userName.click();
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String userPassword) {
        this.userPassword.clear();
        this.userPassword.click();
        this.userPassword.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton() {
        this.loginButton.click();
        return this;
    }

    public boolean logInButtonIsDisplayed() {
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