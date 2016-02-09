package MobileAndroidTests;

import WrappedDriver.ConfigProvider;
import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.io.*;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Parameters;

/**
 * Created by ylysov on 09.02.2016.
 */
public class AndroidTestBase {
    protected RemoteWebDriver androidDriver;

  AppiumDriverLocalService  service;

    @BeforeClass
    @Parameters(value = {"hub", "driverName", "port"})
    public void setUp(String hub, String driverVersion, String port) throws Exception {
        startAVDManager();
        startVirtualDevice();
        startAppiumServer();
        initializeDriver(hub, driverVersion, port);
    }

    @AfterClass
    public void cleanUp() {
        androidDriver.quit();
        stopAppiumServer();
        //avd close
        // avd manager close
    }


    protected  void  startAVDManager(){
        ProcessBuilder pb = new ProcessBuilder(ConfigProvider.getAndroidSDKPath() + "AVD Manager.exe");
        pb.directory(new File(ConfigProvider.getAndroidSDKPath()));

        try {
            Process p = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected  void startVirtualDevice(){
        String Dir =  ConfigProvider.getAndroidSDKPath() + "tools/";
        String Command = ConfigProvider.launchAVD();

        try {
            Process pp =Runtime.getRuntime().exec(Dir + Command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected  void startAppiumServer(){
        service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingDriverExecutable(new File(ConfigProvider.getNodeJsPath()))
                .withAppiumJS(new File (ConfigProvider.getAppiumJsPath())));
        service.start();
    }

    protected  void stopAppiumServer(){
        service.stop();
    }

    protected  void initializeDriver(String hub, String driverVersion, String port)  {
        RemoteBrowser.getInstance().startBrowser(hub, driverVersion, port);
        androidDriver = RemoteBrowser.getInstance().getWebDriver();
    }
}
