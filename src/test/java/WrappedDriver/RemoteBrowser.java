package WrappedDriver;

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
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class RemoteBrowser {
    private RemoteBrowser(){}

    private static String driverName;
    private static String hubName;
    private static String portNumber;
    private static int count = 0;
    private static int restartFrequency = Integer.MAX_VALUE;
    private static String key = null;
    private static RemoteWebDriver webDriver;
    private static DesiredCapabilities capabilities;
    private static RemoteBrowser instance = new RemoteBrowser();

    private RemoteWebDriver singletonWebDriverHolder(){
        count++;

        // 1. WebDriver instance is not created yet
        if (webDriver == null){
            webDriver = createDriverInstance();
            return webDriver;
        }

        // 2. Different flavour of WebDriver is required
        String newKey = hubName + ": " + driverName;
        if (!newKey.equals(key)){
            quit();
            key = newKey;
            return createDriverInstance();
        }
        // 3. Browser is dead
        try {
            webDriver.getCurrentUrl();
        } catch (Throwable t){
            t.printStackTrace();
            return createDriverInstance();
        }

        // 4. It's time to restart
        if (count >= restartFrequency){
            quit();
            return createDriverInstance();
        }

        //5. Use existing WebDriver instance
        return webDriver;
    }

    private RemoteWebDriver createDriverInstance(){
            webDriver = (hubName.equalsIgnoreCase("local")) ? startLocalWebDriver() : startRemoteWebDriver();

        key = hubName + ": " + driverName;
        count = 0;
        return webDriver;
    }

    private RemoteWebDriver startLocalWebDriver(){
        try{
            DriverVersions browserVersions = DriverVersions.valueOf(driverName);

            switch (browserVersions) {
                case ie:
                    webDriver = new InternetExplorerDriver();
                    setInternetExplorerCapabilities();
                    break;
                case firefox:
                    webDriver = new FirefoxDriver();
                    setFirefoxCapabilities();
                    break;
                case chrome:
                    webDriver = new ChromeDriver();
                    setChromeCapabilities();
                    break;
            }
        }catch (EnumConstantNotPresentException e){}
        return webDriver;
    }

    private DesiredCapabilities setInternetExplorerCapabilities() {
        capabilities = DesiredCapabilities.internetExplorer();
        System.setProperty("webdriver.chrome.driver", ConfigProvider.getChromeDriverPath());

        return capabilities;
    }

    private DesiredCapabilities setFirefoxCapabilities() {
        capabilities = DesiredCapabilities.firefox();

        return capabilities;
    }

    private DesiredCapabilities setChromeCapabilities() {
        capabilities = DesiredCapabilities.chrome();
        System.setProperty("webdriver.ie.driver", ConfigProvider.getIEDriverPath());
        return capabilities;
    }

    private DesiredCapabilities setAndroidCapabilities() {
        File appDir = new File("D:\\OneDrive\\Education\\Samples\\SeleniumWebdriverTests\\src\\apps");
        File app = new File(appDir, "Calendar.apk");

        capabilities = DesiredCapabilities.android();
        capabilities.setCapability("deviceName", "TestDevice");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "4.4.2");
        capabilities.setCapability("takesScreenshot", true);
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "am.sunrise.android.calendar");
        capabilities.setCapability("appActivity", "am.sunrise.android.calendar.ui.HomeActivity");

        return capabilities;
    }

    private RemoteWebDriver startRemoteWebDriver(){
        startSeleniumNode();
    try{
        DriverVersions browserVersions = DriverVersions.valueOf(driverName);

        switch (browserVersions){
            case ie:
                capabilities = setInternetExplorerCapabilities();
                webDriver = new RemoteWebDriver(URLBuilder.getRemoteServerUrl(hubName, portNumber), capabilities); break;
            case chrome:
                capabilities = setChromeCapabilities();
                webDriver = new RemoteWebDriver(URLBuilder.getRemoteServerUrl(hubName, portNumber), capabilities); break;
            case firefox:
                capabilities = setFirefoxCapabilities();
                webDriver = new RemoteWebDriver(URLBuilder.getRemoteServerUrl(hubName, portNumber), capabilities); break;
            case Android:
                capabilities = setAndroidCapabilities();
                webDriver = new RemoteWebDriver(URLBuilder.getRemoteServerUrl(hubName, portNumber), capabilities); break;
        }
    }catch (EnumConstantNotPresentException e){}
        return webDriver;
    }

    public void startBrowser(String hub, String driverVersion, String port){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driverName = driverVersion;
        hubName = hub;
        portNumber = port;

        instance.getWebDriver();
        webDriver.manage().window().maximize();
    }

    public static RemoteBrowser getInstance(){
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

    public RemoteWebDriver getWebDriver(){
        return driver.get();
    }

    ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>(){
        @Override
        protected RemoteWebDriver initialValue(){
            webDriver = singletonWebDriverHolder();
            return webDriver;
        }
    };

    public static void startSeleniumGrid (){
        System.out.println("SeleniumGrid is started form: " + ConfigProvider.getSeleniumGridPath());

        ProcessBuilder gridBatFile = new ProcessBuilder(ConfigProvider.getGridBatPath());
        gridBatFile.directory(new File(ConfigProvider.getSeleniumGridPath()));
        try {
            Process seleniumGridProcess = gridBatFile.start();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startSeleniumNode (){
        ProcessBuilder nodeBatFile = new ProcessBuilder(ConfigProvider.getNodeBatPath(hubName));
        nodeBatFile.directory(new File(ConfigProvider.getSeleniumGridPath()));
        try {
            Process seleniumNodeProcess = nodeBatFile.start();
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

    public static void setRestartFrequency(int newRestartFrequency){
        restartFrequency = newRestartFrequency;
    }

    public void navigate(URL url) {
        try{
        webDriver.navigate().to(url);
        } catch (Exception e ){
            System.out.println("Hub name is incorrectly set");
        }
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
        implicitWait(30);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElement (By selector){
        implicitWait(30);
        WebDriverWait wait = new WebDriverWait(getWebDriver(), ConfigProvider.getPageLoadTimeout());
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selector));
    }

    public void waitForAllElements(List<WebElement> elements) {
        implicitWait(30);
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
