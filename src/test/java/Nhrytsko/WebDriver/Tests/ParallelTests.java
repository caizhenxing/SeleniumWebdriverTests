package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class ParallelTests {

    @BeforeSuite
    public void setUp(){
        RemoteBrowser.getInstance().startSeleniumGrid();
    }

    @Test
    @Parameters(value = {"browserName"})
    public void googleTest(String browserType) throws MalformedURLException {
        DesiredCapabilities dr = null;
        if (browserType.equals("firefox")){
            dr = DesiredCapabilities.firefox();
            dr.setBrowserName("firefox");
            dr.setPlatform(Platform.WINDOWS);
        } else{
            dr = DesiredCapabilities.internetExplorer();
            dr.setBrowserName("internet explorer");
            dr.setPlatform(Platform.WINDOWS);
        }

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),dr);

        driver.navigate().to("http://google.com.ua/");
        System.out.println("Test is running in thread #"+Thread.currentThread().getId());
        driver.close();
    }
}
