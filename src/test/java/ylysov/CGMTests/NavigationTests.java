package ylysov.CGMTests;

import org.testng.annotations.Test;

/**
 * Created by ylysov on 11.12.2015.
 */
public class NavigationTests extends TestOrigin {

    @Test
    public void navigateToLoginPage(){
        super.pages.goToLoginPage();
    }

    @Test
    public void loginToApp(){ super.pages.login();
    }

    @Test
    public void navigateToMainPage(){
        super.pages.goToMainPage();
    }

    @Test
    public void navigateToLandingPage(){
        super.pages.goToLandingPage();
    }

    @Test
    public void navigateToEpisodePage(){
        super.pages.goToEpisodePage();
    }

    @Test
    public void navigateToTimelinePage(){super.pages.goToTimelinePage(); }
}
