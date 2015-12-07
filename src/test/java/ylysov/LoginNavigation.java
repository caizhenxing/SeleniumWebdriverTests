package ylysov;


import org.openqa.selenium.WebDriver;

/**
 * Created by ylysov on 04.12.2015.
 */
public class LoginNavigation {

    private static WebDriver driver;
    private static String loginPageUrl = "http://courses.prometheus.org.ua/login";

    public static LoginPage goToLoginPage(WebDriver driver){
        driver = driver;
        driver.navigate().to(loginPageUrl);
        return new LoginPage(driver);
    }

    public static void tearDown(WebDriver driver){
        driver.close();
    }
}

