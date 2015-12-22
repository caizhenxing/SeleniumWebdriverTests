package ovol.Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ovol.Pages.MainPage;
import ovol.Pages.StartPage;
import ovol.Wrapper.BrowserUsage;
import ovol.Wrapper.UsingConfigData;

import java.io.IOException;

/**
 * Created by ovo on 22.12.2015.
 */
public class BaseTest {

    StartPage startPage;
    WebDriver driver;
    MainPage mainPage;

    @BeforeSuite(alwaysRun = true)
    public void WarmingUp () {
        this.driver = BrowserUsage.getWebDriverInstance();
        this.startPage = new StartPage(this.driver);
        try {
            this.mainPage = this.startPage.logInBy(UsingConfigData.getUserName(), UsingConfigData.getUserPassword());
        }catch (IOException e){
            e.printStackTrace();
        }
        BrowserUsage.driverImplicitWaiter(10);
    }



    @AfterSuite(alwaysRun = true)
    public void TurnDown() {
        BrowserUsage.CloseBrowser(this.driver);
    }
}
