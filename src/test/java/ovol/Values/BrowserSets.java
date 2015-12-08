package ovol.Values;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by ovo on 08.12.2015.
 */
public class BrowserSets {

    private static WebDriver browserDriver;

    public static WebDriver BrowserInit(){
        if (browserDriver != null) {
            return browserDriver;
        }
        return new FirefoxDriver();
    }


    public static void BrowserShutDown(WebDriver browserDriver){
        if (browserDriver != null) {
            browserDriver.close();
            }
    }

}

