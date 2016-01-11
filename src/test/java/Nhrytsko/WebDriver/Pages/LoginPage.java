package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Button;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.Input;
import Nhrytsko.WebDriver.WrappedDriver.CustomWebelements.SearchCriteria;
import Nhrytsko.WebDriver.WrappedDriver.RB;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {

    private WebElement userName = new Input(SearchCriteria.Xpath, "//input[@ng-model='loginData.userName']");

    private WebElement userPassword = new Input(SearchCriteria.Xpath, "//input[@cgm-label='Password']");

    private WebElement loginButton = new Button(SearchCriteria.Id, "btnLogin");

    public PageBase logInAs(String userName, String password){
                enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();

        return new PageBase();
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
        RB.waitForAjax();
        WebElement warningMessage = RB.getInstance().findElement(By.xpath("//div[@class='message-text ng-binding']"));
        RB.waitForElement(warningMessage);

        return warningMessage.getText();
    }

//endregion
}