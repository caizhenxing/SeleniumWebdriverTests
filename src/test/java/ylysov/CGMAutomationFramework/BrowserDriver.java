package ylysov.CGMAutomationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ylysov on 10.12.2015.
 */
public class BrowserDriver {

    //region Fields

    //endregion

    private static WebDriver driver;



    //region Constructors

    private static class SingletonHolder{
        private static final WebDriver driverInstance = new FirefoxDriver();
    }

    //endregion

    //region Methods

    public static WebDriver getWebDriverInstance(){
        return SingletonHolder.driverInstance;
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



