package MobileIOSTests;


import WrappedDriver.RemoteBrowser;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * Created by ylysov on 2/10/16.
 */
public class IOSTestBase {

    protected RemoteWebDriver iosDriver;
    protected AppiumDriverLocalService service;

    @BeforeClass
    @Parameters(value = {"hub", "driverName", "port"})
    public void setUp(String hub, String driverVersion, String port) throws Exception{
//        startAVDManager();
//        startVirtualDevice();
//        startAppiumServer();
        initializeDriver(hub, driverVersion, port);
    }


    @AfterClass
    public void cleanUp() {
//        androidDriver.quit();
//        stopAppiumServer();
//        closeVirtualDevice();
        // avd manager close
    }

    protected  void initializeDriver(String hub, String driverVersion, String port)  {
        RemoteBrowser.getInstance().startBrowser(hub, driverVersion, port);
        iosDriver = RemoteBrowser.getInstance().getWebDriver();
    }

}
