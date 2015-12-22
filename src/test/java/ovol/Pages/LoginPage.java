package ovol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ovol.Wrapper.BrowserUsage;

/**
 * Created by ovo on 22.12.2015.
 */
public class LoginPage extends StartPage {
    private WebDriver driver;
    @FindBy (xpath ="/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[1]/div/div/input")
    @CacheLookup
    private WebElement userName;

    @FindBy (xpath = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[2]/div/div/input")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginButton;


    public LoginPage(){
        this.driver = super.driver;
    }

    public  LoginPage enterLogin(String userName) {
        BrowserUsage.driverElementWaiter(this.userName);
        this.userName.click();
        this.userName.sendKeys(userName);
        return this;
    }
    public LoginPage enterPassword(String userPassword) {
        BrowserUsage.driverElementWaiter(this.userPassword);
        this.userPassword.click();
        this.userPassword.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickButton() {
        this.loginButton.click();
        return this;
    }
}
