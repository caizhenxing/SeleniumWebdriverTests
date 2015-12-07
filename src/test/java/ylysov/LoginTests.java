package ylysov;

import Nhrytsko.WebDriver.PageNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by ylysov on 04.12.2015.
 */
public class LoginTests {

    WebDriver driver;

    @BeforeSuite
    public void setUp(){
        driver = new FirefoxDriver();
    }


    @Test
    public void NavigateToLoginPage(){

        String pageTitle= LoginNavigation.goToLoginPage(driver).getLoginPageTitle();

        Assert.assertEquals(pageTitle, "Увійдіть у ваш Prometheus аккаунт | Prometheus");
    }


    @Test
    public void enterInvalidValues(){
        String InvalidEmailValue = "invalid@email.com";
        String InvalidPasswordValue = "invalid";

        LoginNavigation.goToLoginPage(driver);
        LoginPage login = new LoginPage(driver);

        login.fillLoginValues(InvalidEmailValue, InvalidPasswordValue).clickSubmitButton();
        login.findErrorMessage();
        System.out.print("\n enterInvalidValues() -> Part executed");
    }


    @Test
    public void enterValidValues(){

        String ValidEmailValue = "yulysovych@gmail.com";
        String ValidPasswordValue = "a123456";

        LoginNavigation.goToLoginPage(driver);
        LoginPage login = new LoginPage(driver);

        login.fillLoginValues(ValidEmailValue, ValidPasswordValue).clickSubmitButton();

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.titleContains("Панель курсів | Prometheus"));

        String pageTitle = login.getLoginPageTitle();

        Assert.assertEquals(pageTitle, "Панель курсів | Prometheus");
        System.out.print("\n enterValidValues() -> Part executed");
    }

    @AfterSuite
    public void tearDown(){
        PageNavigation.tearDown(driver);
    }

}
