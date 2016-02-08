package MobileAndroidTests;

import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidMobileTestSuite {
    protected RemoteWebDriver androidDriver;

    @Test
    @Parameters(value = {"hub", "driverName", "port"})
    public void FirstTest(String hub, String driverVersion, String port) throws MalformedURLException {
        //RemoteBrowser.startSeleniumGrid();
        RemoteBrowser.getInstance().startBrowser(hub, driverVersion, port);

        androidDriver = RemoteBrowser.getInstance().getWebDriver();
        WebElement element = androidDriver.findElement(By.id("am.sunrise.android.calendar:id/button_connect_with_facebook"));
        element.click();
    }
}
