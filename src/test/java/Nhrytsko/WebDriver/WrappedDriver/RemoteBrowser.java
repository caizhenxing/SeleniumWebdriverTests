package Nhrytsko.WebDriver.WrappedDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class RemoteBrowser {

    //region Fields
    
    //endregion

    //region Constructors

    private static class SingletonHolder{
        private static final WebDriver driverInstance = new FirefoxDriver();
    }
    //endregion

    //region Methods

    public static WebDriver getWebDriverInstance(){
        return SingletonHolder.driverInstance;
        /*String s = ConfigProvider.driverStartOption();
        if (s.equals("local")) {

        }*/
    }

    public static void Quit(WebDriver driver){
        if (driver != null){
            driver.close();
        }
    }

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getWebDriverInstance(), 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void implicitWait(long timeToWaitInSeconds){
        getWebDriverInstance().manage().timeouts().implicitlyWait(timeToWaitInSeconds, TimeUnit.SECONDS);
    }
    //endregion

}
