package ovol.WebDriverTests.PagesTemplates;

import org.openqa.selenium.WebDriver;
import ovol.WebDriverTests.WrappedTestDriver.BrowserWrapper;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusPage {
    WebDriver browserDriver;
    private PrometheusRegisterPage prometheusRegisterPage;
    private final String  prometheusUrl="http://www.prometheus.org.ua/";

    public PrometheusPage(){
        this.browserDriver = BrowserWrapper.BrowserInit();
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
        BrowserWrapper.BrowserShutDown(this.browserDriver);
    }
}
