package tdmytr.CGMAutomationFramework.Selenium;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver
{
    public static WebDriver instance;

    public static String BaseAddress()
    {
        return "http://192.168.241.130:8080/shell-his-module/modules/";
    }

    public static void Initialize()
    {
        instance = new FirefoxDriver();
        instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void Close()
    {
        instance.close();
    }
}