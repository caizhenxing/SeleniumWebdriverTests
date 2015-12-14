package Nhrytsko.WebDriver.Tests;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NavigationTests extends TestBase {

    @Test(groups = {"group1"})
    public void NavigateToMainPage(){
        String title = super.pages.goToMainPage().getMainPageTitle();

        Assert.assertEquals(title, "Prometheus – масові безкоштовні онлайн-курси", "Page titles are not equal");
    }

    @Test (groups = {"group2"})
    public void ClickSignInLink() throws IOException {
        super.pages.goToMainPage().ClickSignInButton();
    }
}
