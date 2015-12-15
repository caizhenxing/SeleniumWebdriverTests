package ovol.WebDriverTests.WrappedTestDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ovo on 08.12.2015.
 */
public class BrowserWrapper {

    //<editor-fold desc="Values for browser">
    private static WebDriver webDriverInstance;
    static InetAddress inetAddress;
    private static final String pingUrl = "192.168.240.39";
    //</editor-fold>

    private static class Singleton {
        private static final WebDriver webDriverInstance = new FirefoxDriver();

    }

    //<editor-fold desc="Warming up browser">
    public static WebDriver BrowserInit() {
        return Singleton.webDriverInstance;
    }
    //</editor-fold>


    //<editor-fold desc="Closing Borwser">
    public static void BrowserShutDown(WebDriver browserDriver) {
        if (browserDriver != null) {
            browserDriver.close();
        }
    }
    //</editor-fold>

    //<editor-fold desc="Pinging site">
    public static void sendPing() throws UnknownHostException {

        try {
            inetAddress.getByName(pingUrl);
            System.out.println("Connection is established :)");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("Connection is lost!");
        }

    }
    //</editor-fold>
}

