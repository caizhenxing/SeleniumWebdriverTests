package ovol.WebDriver.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.WebDriver.Pages.BasePage;
import ovol.WebDriver.Pages.MainPage;
import ovol.WebDriver.WrappedDriver.BrowserSets;

import java.net.UnknownHostException;

/**
 * Created by ovo on 14.12.2015.
 */
public class BaseCGMTest {
    public class FirstTest {

        BasePage basePage;
        MainPage mainPage;
        BrowserSets browserSets;
        //test
        @BeforeSuite
        public void pingTest() throws UnknownHostException {
            browserSets.sendPing();
        }
        @BeforeSuite
        public void stepBefore(){
            this.basePage = new BasePage();
        }

        /* @Test
         public void startTest() {
             startPage.goToLogPage();
         }*/
        @Test
        public void validLogInProcedure(){
            basePage.goToLogPage();
            mainPage.fillUserField();
            mainPage.fillPasswordField();
            mainPage.clickLoginButton();

        }
        @AfterSuite
        public void endTest(){
            BasePage.closePage();
        }
    }
}
