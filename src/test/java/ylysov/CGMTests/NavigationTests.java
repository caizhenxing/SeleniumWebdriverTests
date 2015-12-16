package ylysov.CGMTests;

import org.testng.annotations.Test;

/**
 * Created by ylysov on 11.12.2015.
 */
public class NavigationTests extends TestOrigin {

    @Test(sequential = true)
    public void test1navigateToLoginPage(){
        pages.goToLoginPage();
    }

    @Test(sequential = true)
    public void test2loginToApp(){ pages.login();
    }

    @Test(sequential = true)
    public void test3navigateToLandingPage(){
        pages.goToLandingPage();
    }

    @Test(sequential = true)
    public void test4navigateToEpisodePage()throws InterruptedException{
        pages.goToEpisodePage();
    }

    @Test
    public void test5navigateToTimelinePage(){
        pages.goToTimelinePage(); }    //this test is not working correct
}
