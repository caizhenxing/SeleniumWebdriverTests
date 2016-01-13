package Nhrytsko.WebDriver.WrappedDriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RemoteBrowser {
    private static volatile RemoteBrowser instance;
    private static WebDriver webDriver;

    private static String browserName;
    private static String machine;
    private static int count = 0;
    private static int restartFrequency = Integer.MAX_VALUE;
    private static String key = null;

    public static RemoteBrowser getInstance() {

        RemoteBrowser driverInstance = instance;

        if (driverInstance == null) {
            synchronized (RemoteBrowser.class) {
                driverInstance = instance;
                if (driverInstance == null) {
                    instance =  new RemoteBrowser();
                }
            }
        }
        return instance;
    }

    private WebDriver getWebDriver(){
        count++;

        // 1. WebDriver instance is not created yet
        if (webDriver == null){
            return newWebDriver();
        }

        // 2. Different flavour of WebDriver is required
        String newKey = machine + ": " + browserName;
        if (!newKey.equals(key)){
            quit();
            key = newKey;
            return newWebDriver();
        }
        // 3. Browser is dead
        try {
            webDriver.getCurrentUrl();
        } catch (Throwable t){
            t.printStackTrace();
            return newWebDriver();
        }

        // 4. It's time to restart
        if (count >= restartFrequency){
            quit();
            return newWebDriver();
        }

        //5. Use existing WebDriver instance
        return webDriver;
    }

    private static void setCapabilities(String hub, String browserVersion){
        browserName = browserVersion;
        machine = hub;
    }

    public void jsClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click();", element);
    }

    public void startBrowser(String hub, String browserName){
        RemoteBrowser.setCapabilities(hub, browserName);
        instance.getWebDriver();
        webDriver.manage().window().maximize();
    }

    private WebDriver newWebDriver(){

        webDriver = (machine.equalsIgnoreCase("localhost"))? startLocalWebDriver(): startRemoteWebDriver();

        key = machine + ": " + browserName;
        count = 0;
        return webDriver;
        }

    public static void quit(){
        if (webDriver != null) try {
            webDriver.quit();
            webDriver = null;
            key = null;
        } catch (WebDriverException ex) {}
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                quit();
            }
        });
    }

    private WebDriver startLocalWebDriver(){
        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(browserName);

        switch (browserVersions){
            case IE: webDriver = new InternetExplorerDriver();break;
            case Firefox: webDriver = new FirefoxDriver();break;
            case Chrome: webDriver = new ChromeDriver();break;
        }

        return webDriver;
    }

    private WebDriver startRemoteWebDriver(){

        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(browserName);

                try {
                    switch (browserVersions){
                        case IE: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.internetExplorer());
                        case Chrome: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.chrome());
                        case Firefox: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.firefox());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

        return webDriver;
    }

    public void navigate(URL url) {
        webDriver.navigate().to(url);
    }

    public List<WebElement> findElements(By by) {
        waitForElement(by);
        return webDriver.findElements(by);
    }

    public WebElement findElement(By by) {
        waitForElement(by);
        return webDriver.findElement(by);
    }

    public void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement (By selector){
        WebDriverWait wait = new WebDriverWait(getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void waitForAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void implicitWait(long timeToWaitInSeconds){
        instance.getWebDriver().manage().timeouts().implicitlyWait(timeToWaitInSeconds, TimeUnit.SECONDS);
    }

    public static void waitForDocumentToBeReady(){
        try{
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)instance.getWebDriver())
                            .executeScript("return document.readyState").equals("complete");
                }
            };

            WebDriverWait wait = new WebDriverWait(instance.getWebDriver(), ConfigProvider.getPageLoadTimeout());
            wait.until(pageLoadCondition);}
        catch (Exception e) {
            implicitWait(ConfigProvider.getPageLoadTimeout());
        }
    }

    public static void waitForAjax() {
        Boolean isJqueryUsed = (Boolean)((JavascriptExecutor)instance.getWebDriver())
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if (isJqueryUsed){
            while (true){

                //JavaScript test to verify jQuery is active or not
                Boolean ajaxIsComplete = (Boolean)((JavascriptExecutor)instance.getWebDriver())
                        .executeScript("return jQuery.active ==0");
                if (ajaxIsComplete) break;
                try{
                    Thread.sleep(ConfigProvider.getThreadSleepTimeout());
                }
                catch (InterruptedException e){}
            }
        }
    }
}
