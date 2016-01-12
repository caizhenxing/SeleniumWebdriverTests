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
    private WebDriver webDriver;
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

    public static void setCapabilities(String hub, String browserVersion){
        browserName = browserVersion;
        machine = hub;
    }

    public void jsClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) getWebDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    public void startBrowser(){
        getWebDriver();
    }

    private WebDriver getWebDriver(){
        count++;

        if (webDriver != null){
            return webDriver;
        }

        String newKey = machine + ": " + browserName;
        if (!newKey.equals(key)){
    }
        return newWebDriver();
    }

    private WebDriver newWebDriver(){

        webDriver = (machine.equalsIgnoreCase("localhost"))? startLocalWebDriver(): startRemoteWebDriver();

        key = machine + ": " + browserName;
        count = 0;
        return webDriver;
        }

    public void quit(){
        if (webDriver != null) try {
            webDriver.quit();
            webDriver = null;
            key = null;
        } catch (WebDriverException ex) {}
    }

    private WebDriver startLocalWebDriver(){
        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(browserName);

        switch (browserVersions){
            case Internet_Explorer: webDriver = new InternetExplorerDriver();break;
            case Firefox: webDriver = new FirefoxDriver();break;
            case Chrome: webDriver = new ChromeDriver();break;
        }

        return webDriver;
    }

    private WebDriver startRemoteWebDriver(){

        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(browserName);

                try {
                    switch (browserVersions){
                        case Internet_Explorer: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.internetExplorer());
                        case Chrome: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.chrome());
                        case Firefox: webDriver = new RemoteWebDriver(new URL(machine), DesiredCapabilities.firefox());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

        return webDriver;
    }

    public void navigate(URL url) {
        instance.getWebDriver().navigate().to(url);
    }

    public List<WebElement> findElements(By by) {
        waitForElement(by);
        return instance.getWebDriver().findElements(by);
    }

    public WebElement findElement(By by) {
        waitForElement(by);
        return instance.getWebDriver().findElement(by);
    }

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(instance.getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElement (By selector){
        WebDriverWait wait = new WebDriverWait(instance.getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public static void waitForAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(instance.getWebDriver(), ConfigProvider.getPageLoadTimeout());
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
