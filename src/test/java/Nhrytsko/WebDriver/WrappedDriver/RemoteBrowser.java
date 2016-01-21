package Nhrytsko.WebDriver.WrappedDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RemoteBrowser {
    private RemoteBrowser(){}

    private static String browserName;
    private static String hubName;
    private static int count = 0;
    private static int restartFrequency = Integer.MAX_VALUE;
    private static String key = null;
    private static String defaultHub = ConfigProvider.getDefaultHubURL();
    private static WebDriver webDriver;
    private static RemoteBrowser instance = new RemoteBrowser();

    private static void setCapabilities(String hub, String browserVersion){
        browserName = browserVersion;
        hubName = hub;
    }

    private WebDriver singletonWebDriverHolder(){
        if (webDriver == null){
            webDriver = createDriverInstance();
            return webDriver;
        }
        return webDriver;
    }

    private WebDriver createDriverInstance(){
        webDriver = (hubName.equalsIgnoreCase("localhost"))? startLocalWebDriver(): startRemoteWebDriver();

        key = hubName + ": " + browserName;
        count = 0;
        return webDriver;
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
                case IE: webDriver = new RemoteWebDriver(new URL(hubName), DesiredCapabilities.internetExplorer()); break;
                case Chrome: webDriver = new RemoteWebDriver(new URL(hubName), DesiredCapabilities.chrome()); break;
                case Firefox: webDriver = new RemoteWebDriver(new URL(hubName), DesiredCapabilities.firefox()); break;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return webDriver;
    }

    public void startBrowser(String hub, String browserName){
        setCapabilities(hub, browserName);
        instance.getWebDriver();
        webDriver.manage().window().maximize();
    }

    public static RemoteBrowser getInstance(){
        return instance;
    }

    public WebDriver getWebDriver(){
        return driver.get();
    }

    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>(){
        @Override
        protected WebDriver initialValue(){
            webDriver = singletonWebDriverHolder();
            return webDriver;
        }
    };

    public void startSeleniumGrid (){
        System.out.println("SeleniumGrid is started form: " + ConfigProvider.getSeleniumGridPath());

        ProcessBuilder pb = new ProcessBuilder(ConfigProvider.getGridBatPath());
        pb.directory(new File(ConfigProvider.getSeleniumGridPath()));
        try {
            Process p = pb.start();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void quit(){
        getWebDriver().quit();
        driver.remove();
    }

    public void jsClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("arguments[0].click();", element);
    }

    public static void setDefaultHub(String newDefaultHub) {
        defaultHub = newDefaultHub;
    }

    public static void setRestartFrequency(int newRestartFrequency){
        restartFrequency = newRestartFrequency;
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
