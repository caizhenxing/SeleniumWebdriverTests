package ylysov.CGMTests;

import Nhrytsko.WebDriver.Pages.LandingPage;
import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Tests.TestBase;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

public class NavigationTests2 extends TestBase {

    String patientName = "Hauser";
    WebDriver driver;



    @Test(groups = {"group2"})
    public void t1NavigateToLandingPage(){
        //super.mainPage.clickMenuButton();
        //super.pages.mainPage.clickLandingPageButton();
    }


    @Test(groups = {"group2"})
    public void t2NavigateToEpisodePage() {
        patientName = "Hauser";
//        super.landingPage.InitializeLandingPage();              // Я думаю так воно б мало працювати, але на жаль не працює
//        super.landingPage.enterEpisode(patientName);
//        super.landingPage.selectTopSearchResult();

        LandingPage landingPage = new LandingPage(RemoteBrowser.getWebDriverInstance());              //Так працює, але хочу щоб ініціалізація проходила в PageBase
        PageFactory.initElements(this.driver, landingPage);
        landingPage.enterEpisode(patientName);
        landingPage.selectTopSearchResult();

    }


//    @Test (groups = {"group2"})
//    public void ClickSignInLink() throws IOException {
//    }

}
