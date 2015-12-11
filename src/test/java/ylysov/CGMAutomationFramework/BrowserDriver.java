package ylysov.CGMAutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ylysov on 10.12.2015.
 */
public class BrowserDriver {

    //region Fields

    private static WebDriver driver;

    //endregion

    //region Constructors

    private BrowserDriver(){}


    //endregion

    //region Methods

    public static synchronized WebDriver startWebDriver(){
        if (driver != null){
            return driver;
        }
        return new FirefoxDriver();
        /*String s = ConfigProvider.driverStartOption();
        if (s.equals("local")) {

        }*/
    }

    public static void Quit(WebDriver driver){
        if (driver != null){
            driver.close();
        }
    }
    //endregion

}



