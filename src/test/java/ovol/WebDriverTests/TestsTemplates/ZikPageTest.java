package ovol.WebDriverTests.TestsTemplates;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.WebDriverTests.PagesTemplates.ZikPage;

/**
 * Created by ovo on 07.12.2015.
 */
public class ZikPageTest {

   WebDriver browserDriver;
    ZikPage zikPage;

    @BeforeSuite
    public void FirstStep(){
        this.zikPage = new ZikPage();
    }


    @Test
    public void firefoxForZik(){
        this.zikPage.goToVlada().clickOnTab();


    }

    @AfterSuite
    public void firefoxClose(){
        this.zikPage.KillBrowser();

    }




}
