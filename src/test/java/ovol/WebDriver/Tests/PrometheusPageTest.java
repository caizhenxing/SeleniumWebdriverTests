package ovol.WebDriver.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.WebDriver.Pages.PrometheusPage;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusPageTest {

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
    /*public void textChecking(){
        prometheusPage.GoToSignIn().checkWelcome();
    }*/
    public void emptySubmitTest(){
        prometheusPage.checkEmptySubmit();
    }





    @AfterSuite
    public void BrowserDown(){
        this.prometheusPage.CloseBrowser();
    }

}
