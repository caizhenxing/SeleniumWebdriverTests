package ylysov.grid1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

public class TestBaseGrid {
    WebDriver driver;
//    String StartPageURL = "https://www.google.com.ua/?gfe_rd=cr&ei=xoaKVsOAJ8-BZLjVnNAC";
String StartPageURL = "http://courses.prometheus.org.ua/login";

//    @BeforeClass    //parameter value will retrieved from testng.xml file's <parameter> tag.
//    public static void startGrid()
//    {
//        //Run batch file using java
//        String filePath = "D:\\JavaProject\\SeleniumWebdriverTests\\src\\seleniumGridFiles\\StartGrid.bat";
//        try {
//
//            Process p = Runtime.getRuntime().exec(filePath);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Parameters({"browser"})
    public void startBrowser(String browser) { // Method will pass value of parameter.
        if (browser.equals("FF"))
        { //If value Is FF then webdriver will open Firefox Browser.
            System.out.println("Test Starts Running In Firefox Browser.");
            driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        }
        else if (browser.equals("IE"))
        { // If value Is CRM then webdriver will open chrome Browser.
            System.out.println("Test Starts Running In Internet Explorer.");
            driver = WebDriverFactory.getDriver(DesiredCapabilities.internetExplorer());
        }
        driver.manage().window().maximize();
        driver.navigate().to(StartPageURL);
    }
    @AfterSuite
    public void stopBrowser()
    {
        WebDriverFactory.dismissDriver();
    }
}