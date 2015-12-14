package ovol.WebDriver.Tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.WebDriver.Pages.BasePage;
import ovol.WebDriver.Pages.MainPage;
import ovol.WebDriver.WrappedDriver.RemoteBrowser;

import java.net.UnknownHostException;

/**
 * Created by ovo on 14.12.2015.
 */
public class BaseCGMTest {


        //<editor-fold desc="Dependencies for test">
        static BasePage basePage;
        static MainPage mainPage;
        static RemoteBrowser remoteBrowser;

        //</editor-fold>

        //<editor-fold desc="Preparings for test">
        @BeforeSuite
        public void pingTest() throws UnknownHostException {
            remoteBrowser.sendPing();
        }
        @BeforeSuite
        public void stepBefore(){
            this.remoteBrowser = RemoteBrowser.
            this.mainPage = new MainPage(this.);
        }
        //</editor-fold>

        /* @Test
         public void startTest() {
             basePage.goToLogPage();
         }*/
        //<editor-fold desc="Test body">
        @Test
        public void validLogInProcedure(){
            basePage.goToLogPage();
            mainPage.fillUserField();
            mainPage.fillPasswordField();
            mainPage.clickLoginButton();

        }
    //</editor-fold>
    //<editor-fold desc="Ending test">
    @AfterSuite
        public void endTest(){
            basePage.closePage();
        }
    //</editor-fold>
    }

