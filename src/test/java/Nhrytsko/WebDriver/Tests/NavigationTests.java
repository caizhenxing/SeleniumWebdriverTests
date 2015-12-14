package Nhrytsko.WebDriver.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends TestBase {

    @Test(groups = {"group1"})
    public void NavigateToMainPage(){
        String title = super.pages.goToMainPage().getMainPageTitle();

        Assert.assertEquals(title, "Prometheus – масові безкоштовні онлайн-курси", "Page titles are not equal");
    }

    @Test (groups = {"group2"})
    public void ClickSignInLink(){
        super.pages.goToMainPage().ClickSignInButton();
    }
}
