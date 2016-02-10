package WrappedDriver;

/**
 * Created by ylysov on 2/10/16.
 */
public class MacConfigProvider extends ConfigProvider{

    public static String getAppsDirectoryPath() {
        String appDir = getSolutionFolderPath() + "/src/apps/";
        return appDir;
    }

}
