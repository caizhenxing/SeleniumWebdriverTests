package Nhrytsko.WebDriver.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

class LoginPage extends PageBase {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[1]/div/div/input")
    @CacheLookup
    private WebElement userName;

    @FindBy(xpath = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[2]/div/div/input")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginButton;

    public LoginPage() {
        this.driver = super.driver;
    }

    public LoginPage enterUserName(String userName) {
        //super.waiForElementToBeReady();
        this.userName.click();
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String userPassword) {
        //super.waiForElementToBeReady();
        this.userPassword.click();
        this.userPassword.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton(){
        this.loginButton.click();
        return this;
    }
}
