package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    WebDriverWait wait;

    final String emailInputLink = "//input[@name='userName']";
    final String passwordInputLink = "//input[@name='password']";
    final String loginButtonLink = "btnLogin";

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }


    public  LoginPage fillEmail(String s1) {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(emailInputLink)));

        emailInput = driver.findElement(By.xpath(emailInputLink));
        emailInput.click();
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
