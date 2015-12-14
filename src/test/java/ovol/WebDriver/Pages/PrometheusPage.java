package ovol.WebDriver.Pages;

import org.openqa.selenium.WebDriver;
import ovol.WebDriver.WrappedDriver.BrowserSets;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusPage {
    WebDriver browserDriver;
    private PrometheusRegisterPage prometheusRegisterPage;
    private final String  prometheusUrl="http://www.prometheus.org.ua/";

    public PrometheusPage(){
        this.browserDriver = BrowserSets.BrowserInit();
        this.prometheusRegisterPage = new PrometheusRegisterPage(this.browserDriver);

    }

    public PrometheusRegisterPage GoToSignIn (){
        browserDriver.navigate().to(prometheusUrl);
        return new PrometheusRegisterPage(this.browserDriver);

    }

    public void  checkEmptySubmit() {
        prometheusRegisterPage.clickSubmitButton();

    }

    public void CloseBrowser(){
        BrowserSets.BrowserShutDown(this.browserDriver);
    }
}
