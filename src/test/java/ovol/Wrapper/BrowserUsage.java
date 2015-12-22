package ovol.Wrapper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovo on 22.12.2015.
 */
public class BrowserUsage {

    //region WebDriver constructor
    private static class SingleToneBox{
        private static final WebDriver driverInstance = new FirefoxDriver();
    }
    //endregion

    //region BrowserMethods
    public static WebDriver getWebDriverInstance(){
        return SingleToneBox.driverInstance;

    }
    public static void CloseBrowser (WebDriver driver){
        if (driver != null){
            driver.close();
        }
    }
    public static void driverElementWaiter(WebElement element){
        WebDriverWait waiter = new WebDriverWait(getWebDriverInstance(), 10);
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
    public static void driverImplicitWaiter (long timeForWaiterSeconds){
        getWebDriverInstance().manage().timeouts().implicitlyWait(timeForWaiterSeconds, TimeUnit.SECONDS);
    }
    //endregion
}
