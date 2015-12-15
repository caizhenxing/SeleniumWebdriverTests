package ovol.WebDriverTests.PagesTemplates;

import org.openqa.selenium.WebDriver;
import ovol.WebDriverTests.WrappedTestDriver.BrowserWrapper;

/**
 * Created by ovo on 08.12.2015.
 */
public class ZikPage {
    WebDriver browserDriver;

    private TabVlada tabVlada;

    private final String zikUrl = "http://www.zik.ua";



    public  ZikPage() {
        this.browserDriver = BrowserWrapper.BrowserInit();
        this.tabVlada = new TabVlada(this.browserDriver);
    }

    public  TabVlada goToVlada(){
        browserDriver.navigate().to(zikUrl);
        return new TabVlada(this.browserDriver);
    }

    public void KillBrowser(){
        BrowserWrapper.BrowserShutDown(this.browserDriver);
    }

}
