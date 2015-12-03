package Nhrytsko.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by nhrytsko on 12/2/2015.
 */
public class PageNavigation {

    private static WebDriver driver;
    private static String mainPageUrl = "http://prometheus.org.ua/";

    public static MainPage goToMainPage(WebDriver driver){
        driver = driver;
        driver.navigate().to(mainPageUrl);
        return new MainPage(driver);
    }

    public static void tearDown(WebDriver driver){
        driver.close();
    }
}
