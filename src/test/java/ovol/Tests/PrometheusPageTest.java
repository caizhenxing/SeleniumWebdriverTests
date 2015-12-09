package ovol.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.PageTemplates.PrometheusPage;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusPageTest {
    WebDriver browserDriver;
    PrometheusPage prometheusPage;

    @BeforeSuite
    public void StartStep(){
        this.prometheusPage = new PrometheusPage();
            }

    @Test
    public void firefoxForPrometheus(){
        prometheusPage.GoToSignIn().clickButton();
    }

    @Test
    public void textChecking(){
        prometheusPage.GoToSignIn().checkWelcome();
    }






    @AfterSuite
    public void BrowserDown(){
        this.prometheusPage.CloseBrowser();
    }

}
