package ovol.WebDriverTests.TestsTemplates;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import ovol.WebDriverTests.PagesTemplates.TestBasePage;
import ovol.WebDriverTests.PagesTemplates.TestMainPage;
import ovol.WebDriverTests.WrappedTestDriver.BrowserWrapper;

import java.net.UnknownHostException;



public class BaseCGMTest {


        //<editor-fold desc="Dependencies for test">
        static TestBasePage testBasePage;
        static TestMainPage testMainPage;
        static BrowserWrapper browserWrapper;

        //</editor-fold>

        //<editor-fold desc="Preparings for test">
        @BeforeSuite
        public void pingTest() throws UnknownHostException {
            browserWrapper.sendPing();
        }
 @BeforeSuite
        public void stepBefore(){
            BrowserWrapper.BrowserInit();

        }

        //</editor-fold>

 @Test
         public void startTest() {
             testBasePage.goToLogPage();
         }

        //<editor-fold desc="Test body">
        @Test
        public void validLogInProcedure(){
            testBasePage.goToLogPage();
            testMainPage.fillUserField();
            testMainPage.fillPasswordField();
            testMainPage.clickLoginButton();

        }
    //</editor-fold>
    //<editor-fold desc="Ending test">
    @AfterSuite
        public void endTest(){
            testBasePage.closePage();
        }
    //</editor-fold>
    }

