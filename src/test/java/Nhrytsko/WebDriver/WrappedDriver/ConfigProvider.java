package Nhrytsko.WebDriver.WrappedDriver;

import java.io.*;
import java.net.URL;
import java.util.Properties;

public class ConfigProvider {

    static File configFile;
    static Properties properties;
    static FileInputStream inputStream;

    private static Properties ConfigurationParameters() throws IOException {
        configFile = new File("TestConfiguration.properties");
        properties = new Properties();
        inputStream = new FileInputStream(configFile);
        properties.load(inputStream);

        return properties;
    }

    public static String getValidUserName() {
        try {
            return ConfigurationParameters().getProperty("userName");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getValidUserPassword() {
        try {
            return ConfigurationParameters().getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getDriverStartOption () {
        try {
            return ConfigurationParameters().getProperty("driverStartOption");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getPageLoadTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("pageLoadTimeout"));
            return pageLoadTimeout;
    }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getThreadSleepTimeout(){
        try{
            long pageLoadTimeout = Long.parseLong(ConfigurationParameters().getProperty("threadSleepTimeout"));
            return pageLoadTimeout;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static URL getBaseURL() {
        try {
            URL url = new URL (ConfigurationParameters().getProperty("130_VirtualMachineURL"));
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPingUrl() {
        try {
            return ConfigurationParameters().getProperty("pingUrl");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPageUrl() {
        try {
            return ConfigurationParameters().getProperty("39_VirtualMachineURL");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPatientData() {
        try {
            return ConfigurationParameters().getProperty("patient");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInvalidUserName(){
        try {
            return ConfigurationParameters().getProperty("wrongName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getInvalidUserPassword() {
        try {
            return ConfigurationParameters().getProperty("wrongPassword");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getPatientName() {
        try {
            return ConfigurationParameters().getProperty("patientName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String getPatientEpisode() {
        try {
            return ConfigurationParameters().getProperty("patientEpisode");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDriverBrowserVersion(){
        try {
            return ConfigurationParameters().getProperty("driverBrowserVersion");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRemoteSeleniumServerName(){
        try {
            return ConfigurationParameters().getProperty("remoteSeleniumServerName");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getRemoteSeleniumServerPort(){
        try {
            return ConfigurationParameters().getProperty("remoteSeleniumServerPort");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
