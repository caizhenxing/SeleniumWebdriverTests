package ylysov.grid1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;


public class TestBaseForGrid {

    WebDriver driver;
    String StartPageURL = "http://192.168.240.39:8080/shell-his-module/modules/login.html";
    String driverName;

    @BeforeSuite
    public void startGrid(){
        SeleniumGrid grid = new SeleniumGrid();
        try {
            grid.StartGrid();}
        catch (Exception e) { System.out.println ("Grid is not started");}
    }

    @BeforeClass
    @Parameters({"browser"})              //parameter value will retrieved from testng.xml file's <parameter> tag.
    public void startBrowser(String browser){ // Method will pass value of parameter.
         if (browser.equals("FF"))
        { //If value Is FF then webdriver will open Firefox Browser.
            System.out.println("Test Starts Running In Firefox Browser.");
            driver = WebDriverFactory.getDriver(DesiredCapabilities.firefox());
            String driverName ="firefox";
        }
        else if (browser.equals("IE"))
        { // If value Is CRM then webdriver will open chrome Browser.
            System.out.println("Test Starts Running In Internet Explorer.");
            driver = WebDriverFactory.getDriver(DesiredCapabilities.internetExplorer());
            driverName = "internet explorer";
        }
         else if (browser.equals("Chrome"))
         { // If value Is CRM then webdriver will open chrome Browser.
             System.out.println("Test Starts Running In Internet Explorer.");
             driver = WebDriverFactory.getDriver(DesiredCapabilities.chrome());

         }
        driver.manage().window().maximize();
        driver.navigate().to(StartPageURL);
    }
    @AfterSuite
    public void stopBrowser()
    {
        WebDriverFactory.dismissDriver();
        System.out.println("Closing browser - " + driverName);
    }
}