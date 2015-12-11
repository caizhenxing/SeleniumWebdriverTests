package Nhrytsko.WebDriver.WrappedDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RemoteBrowser {

    //region Fields



    //endregion

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
