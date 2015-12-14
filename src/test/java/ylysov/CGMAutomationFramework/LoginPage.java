package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ylysov on 10.12.2015.
 */
public class LoginPage {

    WebDriver driver;

//    @FindBy(xpath = "//input[@name='userName']")
//    @CacheLookup
    WebElement emailInput;

//    @FindBy(xpath = "//input[@name='password']")
//    @CacheLookup
    WebElement passwordInput;

//    @FindBy(id = "btnLogin")
//    @CacheLookup
    WebElement loginButton;

    final String emailInputLink = "//input[@name='userName']";
    final String passwordInputLink = "//input[@name='password']";
    final String loginButtonLink = "btnLogin";

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }


//    private final String loginPageUrl = "http://192.168.240.39:8080/shell-his-module/modules/login.html";

//    public BrowserDriver goToLoginPage(String loginPageUrl) {
//        driver = driver;
//        driver.navigate().to("http://192.168.240.39:8080/shell-his-module/modules/login.html");
//        return new BrowserDriver();
//
//    }

    public  LoginPage fillEmail(String s1) {
        emailInput = driver.findElement(By.xpath(emailInputLink));
        emailInput.sendKeys(s1);
        return this;

    }

    public  LoginPage fillPassword(String s2) {
        passwordInput = driver.findElement(By.xpath(passwordInputLink));
        passwordInput.sendKeys(s2);
        return this;
    }

    public void login() {
        loginButton =   driver.findElement(By.id(loginButtonLink));
        loginButton.click();
    }
}
