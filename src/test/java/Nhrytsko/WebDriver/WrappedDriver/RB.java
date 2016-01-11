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

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RB {
    private static volatile RB instance;
    private WebDriver webDriver;
    WebDriverWait wait;

   /* public static RB getInstance(){
        if (instance == null){
            instance = new RB();
            instance.startWebDriver();
            return instance;
        }

        return instance;
    }*/

    public static RB getInstance() {

        RB driverInstance = instance;

        if (driverInstance == null) {
            synchronized (RB.class) {
                driverInstance = instance;
                if (driverInstance == null) {
                    instance = driverInstance = new RB();
                }
            }
        }
        return instance;
    }

    public void jsClick(WebElement element){
        JavascriptExecutor jse = (JavascriptExecutor) startWebDriver();
        jse.executeScript("arguments[0].click();", element);
    }

    public void startBrowser(){
        startWebDriver();
    }

    private WebDriver startWebDriver(){
        if (webDriver != null){
            return webDriver;
        }

        String driverStartOption = ConfigProvider.getDriverStartOption();

        try{
            if (driverStartOption.equals("local")) webDriver = startLocalWebDriver();
            if (driverStartOption.equals("remote")) webDriver = startRemoteWevDriver();
        }catch (Exception e){
            System.out.println("Incorrect driver start option is set");
        }
        return webDriver;
    }

    public void quit(){
        startWebDriver().quit();
    }

    private WebDriver startLocalWebDriver(){
        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(ConfigProvider.getDriverBrowserVersion());

        switch (browserVersions){
            case Internet_Explorer: webDriver = new InternetExplorerDriver();break;
            case Firefox: webDriver = new FirefoxDriver();break;
            case Chrome: webDriver = new ChromeDriver();break;
        }

        return webDriver;
    }

    private WebDriver startRemoteWevDriver(){
        DriverBrowserVersions browserVersions = DriverBrowserVersions.valueOf(ConfigProvider.getDriverBrowserVersion());

        switch (browserVersions){
            case Internet_Explorer: webDriver = new RemoteWebDriver(URLBuilder.getRemoteSeleniumServerUrl(),
                    DesiredCapabilities.internetExplorer());break;

            case Firefox: webDriver = new RemoteWebDriver(URLBuilder.getRemoteSeleniumServerUrl(),
                    DesiredCapabilities.firefox());break;

            case Chrome: webDriver = new RemoteWebDriver(URLBuilder.getRemoteSeleniumServerUrl(),
                    DesiredCapabilities.chrome());break;
        }

        return webDriver;
    }

    public void navigate(URL url) {
        instance.startWebDriver().navigate().to(url);
    }

    public List<WebElement> findElements(By by) {
        waitForElement(by);
        return instance.startWebDriver().findElements(by);
    }

    public WebElement findElement(By by) {
        waitForElement(by);
        return instance.startWebDriver().findElement(by);
    }

    public static void waitForElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(instance.startWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElement (By selector){
        WebDriverWait wait = new WebDriverWait(instance.startWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public static void waitForAllElements(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(instance.startWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void implicitWait(long timeToWaitInSeconds){
        instance.startWebDriver().manage().timeouts().implicitlyWait(timeToWaitInSeconds, TimeUnit.SECONDS);
    }

    public static void waitForDocumentToBeReady(){
        try{
            ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                public Boolean apply(WebDriver driver) {
                    return ((JavascriptExecutor)instance.startWebDriver())
                            .executeScript("return document.readyState").equals("complete");
                }
            };

            WebDriverWait wait = new WebDriverWait(instance.startWebDriver(), ConfigProvider.getPageLoadTimeout());
            wait.until(pageLoadCondition);}
        catch (Exception e) {
            implicitWait(ConfigProvider.getPageLoadTimeout());
        }
    }

    public static void waitForAjax() {
        Boolean isJqueryUsed = (Boolean)((JavascriptExecutor)instance.startWebDriver())
                .executeScript("return (typeof(jQuery) != 'undefined')");
        if (isJqueryUsed){
            while (true){

                //JavaScript test to verify jQuery is active or not
                Boolean ajaxIsComplete = (Boolean)((JavascriptExecutor)instance.startWebDriver())
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
