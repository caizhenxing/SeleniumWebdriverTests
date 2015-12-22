package ovol.Wrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ovo on 22.12.2015.
 */
public class UsingConfigData {

    static File configFile;
    static Properties properties;
    static FileInputStream inputStream;

    private static Properties getConfigData() throws IOException{
        configFile = new File("ConfigData.properties");
        properties = new Properties();
        inputStream = new FileInputStream(configFile);

        properties.load(inputStream);
        return properties;
    }
    public static String getPingUrl() throws IOException{
        return getConfigData().getProperty("pingUrl");
    }
    public static String getPageUrl() throws IOException{
        return getConfigData().getProperty("pageUrl");
    }

    public static String getUserName() throws IOException{
        return getConfigData().getProperty("login");
    }
    public static String getUserPassword() throws IOException{
        return getConfigData().getProperty("password");
    }
    public static String getPatientData() throws IOException {
        return getConfigData().getProperty("patient");
    }

}