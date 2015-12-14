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

    public static String getUserName() throws IOException {
        return ConfigurationParameters().getProperty("userName");
    }

    public static String getDriverStartOption () throws IOException {
        return ConfigurationParameters().getProperty("driverStartOption");
    }
}
