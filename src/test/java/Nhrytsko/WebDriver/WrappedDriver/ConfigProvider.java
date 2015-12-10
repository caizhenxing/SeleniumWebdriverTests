package Nhrytsko.WebDriver.WrappedDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigProvider {

    static File configFile;
    static FileReader reared;
    static Properties config;

    private static Properties ConfigurationParameters(){

        try {
            configFile = new File("TestConfiguration.properties");
            reared = new FileReader(configFile);
            config = new Properties();

            config.load(reared);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return config;
    }

    static String userName(){
         return ConfigurationParameters().getProperty("userName");
    }

    static String driverStartOption (){
        return ConfigurationParameters().getProperty("driverStartOption");
    }
}
