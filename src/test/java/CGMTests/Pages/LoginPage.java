package CGMTests.Pages;

import WrappedDriver.CustomWebelements.Button;
import WrappedDriver.CustomWebelements.Input;
import WrappedDriver.CustomWebelements.PageElement;
import WrappedDriver.CustomWebelements.SearchCriteria;
import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends WebPageBase {

    private PageElement userName = new Input(SearchCriteria.Xpath, "//input[@ng-model='loginData.userName']");

    private PageElement userPassword = new Input(SearchCriteria.Xpath, "//input[@cgm-label='Password']");

    private PageElement loginButton = new Button(SearchCriteria.Id, "btnLogin");

    public WebPageBase logInAs(String userName, String password){
                enterUserName(userName)
                .enterUserPassword(password)
                .clickLoginButton();

        return new WebPageBase();
    }

    //region Methods

    public PageElement returnLoginButton(){
        return this.loginButton;
    }

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
        WebElement warningMessage = RemoteBrowser.getInstance().findElement(By.xpath("//div[@class='message-text ng-binding']"));
        RemoteBrowser.getInstance().waitForElement(warningMessage);

        return warningMessage.getText();
    }

//endregion
}