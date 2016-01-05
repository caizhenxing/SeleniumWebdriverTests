package ylysov.grid1;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
    // Factory settings
    private static String defaultHub = "http://localhost:4444/wd/hub"; // change to
    // "http://myserver:4444/wd/hub" to
// use remote webdriver by default
    private static int restartFrequency = Integer.MAX_VALUE;
    public static void setDefaultHub(String newDefaultHub) {
        defaultHub = newDefaultHub;
    }
    public static void setRestartFrequency(int newRestartFrequency) {
        restartFrequency = newRestartFrequency;
    }
    // Factory
    private static String key = null;
    private static int count = 0;
    private static WebDriver driver;
    public static WebDriver getDriver(String hub, Capabilities capabilities) {
        count++;
// 1. WebDriver instance is not created yet
        if (driver == null) {
            return newWebDriver(hub, capabilities);
        }
// 2. Different flavour of WebDriver is required
        String newKey = capabilities.toString() + ":" + hub;
        if (!newKey.equals(key)) {
            dismissDriver();
            key = newKey;
            return newWebDriver(hub, capabilities);
        }
// 3. Browser is dead
        try {
            driver.getCurrentUrl();
        } catch (Throwable t) {
            t.printStackTrace();
            return newWebDriver(hub, capabilities);
        }
// 4. It's time to restart
        if (count >= restartFrequency) {
            dismissDriver();
            return newWebDriver(hub, capabilities);
        }
// 5. Just use existing WebDriver instance
        return driver;
    }
    public static WebDriver getDriver(Capabilities capabilities) {
        return getDriver(defaultHub, capabilities);
    }
    public static void dismissDriver() {
        if (driver != null) {
            try {
                driver.quit();
                driver = null;
                key = null;
            } catch (WebDriverException ex) {
// it can already be dead or unreachable
            }
        }
    }
    // Factory internals
    private static WebDriver newWebDriver(String hub, Capabilities capabilities) {
        driver = (hub == null)
                ? createLocalDriver(capabilities)
                : createRemoteDriver(hub, capabilities);
        key = capabilities.toString() + ":" + hub;
        count = 0;
        return driver;
    }
    private static WebDriver createRemoteDriver(String hub,
                                                Capabilities capabilities) {
        try {
            return new RemoteWebDriver(new URL(hub), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new Error("Could not connect to WebDriver hub", e);
        }
    }
    private static WebDriver createLocalDriver(Capabilities capabilities) {
        String browserType = capabilities.getBrowserName();
        if (browserType.equals("firefox"))
            return new FirefoxDriver(capabilities);
        if (browserType.startsWith("internet explorer"))
            return new InternetExplorerDriver(capabilities);
        if (browserType.equals("chrome"))
            return new ChromeDriver(capabilities);
        if (browserType.equals("opera"))
            return new OperaDriver(capabilities);
        throw new Error("Unrecognized browser type: " + browserType);
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                dismissDriver();
            }
        });
    }
    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
    public static void implicitWait(long timeToWaitInSeconds){
        driver.manage().timeouts().implicitlyWait(timeToWaitInSeconds, TimeUnit.SECONDS);
    }
}