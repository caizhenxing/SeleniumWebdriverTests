package ylysov.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ylysov.grid1.WebDriverFactory;

public class LoginPage extends PageBase2 {

    @FindBy(xpath = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[1]/div/div/input")
    @CacheLookup
    private WebElement userName;

    @FindBy(xpath = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[2]/div/div/input")
    @CacheLookup
    private WebElement userPassword;

    @FindBy(id = "btnLogin")
    @CacheLookup
    private WebElement loginButton;

    //endregion
    @FindBy (xpath = "//div[@class='message-toast message-toast-neutral']")
    @CacheLookup
    private WebElement warningMessage;

    public LoginPage (WebDriver driver){
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    //region Methods
    public LoginPage enterUserName(String userName) {
       WebDriverFactory.waitForElement(this.userName);
        this.userName.click();
        this.userName.sendKeys(userName);
        return this;
    }

    public LoginPage enterUserPassword(String userPassword) {
        WebDriverFactory.waitForElement(this.userPassword);
        this.userPassword.click();
        this.userPassword.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton(){
        this.loginButton.click();
        return this;
    }

    public boolean logInButtonIsDisplayed() {
        RemoteBrowser.waitForElement(this.loginButton);
        return this.loginButton.isDisplayed();
    }

    public String getWarningMessage() throws InterruptedException {
        Thread.sleep(1000);
        RemoteBrowser.waitForElement(this.warningMessage);
        return this.warningMessage.getText();
    }
    //endregion
}
