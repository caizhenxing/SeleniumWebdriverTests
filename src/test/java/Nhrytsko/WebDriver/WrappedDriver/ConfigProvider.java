package Nhrytsko.WebDriver.WrappedDriver;

import java.io.*;
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

    public static String getDriverStartOption () throws IOException {
        return ConfigurationParameters().getProperty("driverStartOption");
    }

    public static String getBaseURL() throws IOException{
        return ConfigurationParameters().getProperty("130_VirtualMachineURL");
    }
    public static String getPingUrl() throws IOException{
        return ConfigurationParameters().getProperty("pingUrl");
    }
    public static String getPageUrl() throws IOException{
        return ConfigurationParameters().getProperty("pageUrl");
    }
    public static String getPatientData() throws IOException {
        return ConfigurationParameters().getProperty("patient");
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

    public static String getPatientName() throws IOException {
        return ConfigurationParameters().getProperty("patientName");
    }
}
