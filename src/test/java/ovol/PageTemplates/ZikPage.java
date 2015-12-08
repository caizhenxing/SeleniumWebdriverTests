package ovol.PageTemplates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ovol.Values.BrowserSets;

/**
 * Created by ovo on 08.12.2015.
 */
public class ZikPage {
    WebDriver browserDriver;
    WebElement elementOnPage;
    private TabVlada tabVlada;

    private final String zikUrl = "http://www.zik.ua";



    public  ZikPage() {
        this.browserDriver = BrowserSets.BrowserInit();
        this.tabVlada = new TabVlada(this.browserDriver);
    }

    public  TabVlada goToVlada(){
        browserDriver.navigate().to(zikUrl);
        return new TabVlada(this.browserDriver);
    }

    public void KillBrowser(){
        BrowserSets.BrowserShutDown(this.browserDriver);
    }

}
