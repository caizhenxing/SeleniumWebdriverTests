package ovol.WebDriver.WrappedDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by ovo on 08.12.2015.
 */
public class BrowserSets {

    //<editor-fold desc="Values for browser">
    private static WebDriver webDriver;
    static InetAddress inetAddress;
    private static final String pingUrl = "192.168.240.39";
    //</editor-fold>

    //<editor-fold desc="Warming up browser">
    public static WebDriver BrowserInit() {
        if (webDriver != null) {
            return webDriver;
        }
        return new FirefoxDriver();
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

