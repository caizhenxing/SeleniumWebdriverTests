package ovol.WebDriver.Pages;

import Nhrytsko.WebDriver.Pages.MainPage;
import org.openqa.selenium.WebDriver;
import ovol.WebDriver.WrappedDriver.BrowserSets;

/**
 * Created by ovo on 14.12.2015.
 */
public class BasePage {

    static BrowserSets browserSets;
    static WebDriver webDriver;
    private MainPage mainPage;
    private static final String mainUrl = "http://192.168.240.39:8080/shell-his-module/modules/index.html";

    public BasePage (){
        this.webDriver = BrowserSets.BrowserInit();
        this.mainPage = new MainPage(this.webDriver);
    }

    public MainPage goToLogPage(){
        webDriver.navigate().to(mainUrl);
        return new MainPage(webDriver);

    }

    public static void closePage(){
        browserSets.BrowserShutDown(webDriver);
    }
}
