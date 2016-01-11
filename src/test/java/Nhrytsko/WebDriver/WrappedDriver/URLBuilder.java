package Nhrytsko.WebDriver.WrappedDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class URLBuilder {

    public static URL getRemoteSeleniumServerUrl() {
        try {
            return new URL(String.format("%1:%2/", ConfigProvider.getRemoteSeleniumServerName(), ConfigProvider.getRemoteSeleniumServerPort()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
