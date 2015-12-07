package Nhrytsko.WebDriver.WrappedDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RemoteBrowser {

    //region Fields

    private static WebDriver driver;

    //endregion

    //region Constructors

    private RemoteBrowser(){}


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
