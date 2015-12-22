package ovol.Tests;

import org.testng.annotations.Test;
import ovol.Wrapper.BrowserUsage;

/**
 * Created by ovo on 22.12.2015.
 */
public class NavigateTest extends BaseTest {
    @Test
    public void Test()  {
        BrowserUsage.driverImplicitWaiter(10);
        this.mainPage.clickMenuButton();
        this.mainPage.clickLandingPage();

    }

}
