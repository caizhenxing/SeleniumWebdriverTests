package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ylysov on 10.12.2015.
 */
public class LoginPage {

    WebDriver driver;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement loginButton;

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


    final String emailInputLink = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[1]/div/div/input";

    public  LoginPage fillEmail(String s1) {
        emailInput = driver.findElement(By.xpath(emailInputLink));
        emailInput.sendKeys(s1);
        return this;

    }

    final String passwordInputLink = "/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[2]/div/div/input";

    public  LoginPage fillPassword(String s2) {
        passwordInput = driver.findElement(By.xpath(passwordInputLink));
        passwordInput.sendKeys(s2);
        return this;

    }

    final String loginButtonLink = "btnLogin";

    public void login() {
        loginButton = driver.findElement(By.id(loginButtonLink));
        loginButton.click();
    }
}
