package ovol.WebDriver.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ovo on 14.12.2015.
 */
public class MainPage {
    static WebDriver webDriver;
    static WebElement loginField;
    static WebElement passwordField;
    static WebElement loginButton;
    static WebDriverWait webWaiter;

    //private static final String fieldForLogin = "cgm-col-lg-12";
    private static final String loginFieldId = "#e7ac6817-f3ce-46a0-9c83-440d22c07c77";
    private static final String passwordFieldId = "#\\39 8c8ee42-22c3-43f7-822a-73d5ce8d676d";
    private static final String loginButtonID = "btnLogin";
    private static final String validLoginName = "g3his";
    private static final String validPasswordValue = "g3his";
    private static final String invalidLogValue = "4ebUraT0R";


    public MainPage (WebDriver webDriver) {
        this.webDriver = webDriver;
        webWaiter = new WebDriverWait(webDriver, 5);

    }



    public static void fillUserField() {
        //webWaiter.until();

        loginField = webDriver.findElement(By.cssSelector(loginFieldId));
        loginField.sendKeys(validLoginName);
    }
    public static void fillInvalidUserField() {
        //webWaiter.until();
        loginField = webDriver.findElement(By.cssSelector(loginFieldId));
        loginField.sendKeys(invalidLogValue);
    }

    public static void fillPasswordField(){
        passwordField = webDriver.findElement(By.cssSelector(passwordFieldId));
        passwordField.sendKeys(validPasswordValue);
    }

    public static void fillInvalidPasswordField(){
        passwordField = webDriver.findElement(By.cssSelector(passwordFieldId));
        passwordField.sendKeys(invalidLogValue);
    }

    public static void clickLoginButton(){
        loginButton = webDriver.findElement(By.id(loginButtonID));
        loginButton.click();
    }
}
