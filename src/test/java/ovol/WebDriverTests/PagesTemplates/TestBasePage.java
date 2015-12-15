package ovol.WebDriverTests.PagesTemplates;

import org.openqa.selenium.WebDriver;
import ovol.WebDriverTests.WrappedTestDriver.BrowserWrapper;

/**
 * Created by ovo on 14.12.2015.
 */
public class TestBasePage {

    static BrowserWrapper browserWrapper;
    static WebDriver webDriver;
    private TestBasePage mainPage;
    private static final String mainUrl = "http://192.168.240.39:8080/shell-his-module/modules/index.html";

    public TestBasePage(WebDriver webDriver){
        this.webDriver = BrowserWrapper.BrowserInit();
        //mainPage = new TestMainPage(this.webDriver);
    }

    public TestBasePage(){

    }

    public static  TestMainPage goToLogPage(){
        webDriver.navigate().to(mainUrl);
        return new TestMainPage();

    }
    public static void closePage(){
        browserWrapper.BrowserShutDown(webDriver);
    }
}
