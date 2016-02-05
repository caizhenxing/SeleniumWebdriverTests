package CGMTests.Tests.ylysov.ParallelTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

/**
 * Created by ylysov on 28.12.2015.
 */
public class TestBaseForParallel {

    WebDriver driver;
    String StartPageURL = "http://192.168.240.39:8080/shell-his-module/modules/login.html";

    @BeforeClass
    //parameter value will retrieved from testng.xml file's <parameter> tag.
    @Parameters({"browser"})
    public void startBrowser(String browser) {     // Method will pass value of parameter.

        if (browser.equals("FF"))
        {                                          //If value Is FF then webdriver will open Firefox Browser.
          System.out.println("Test Starts Running In Firefox Browser.");
          driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
        }

        else if (browser.equals("IE"))
        {                                          // If value Is CRM then webdriver will open chrome Browser.
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

