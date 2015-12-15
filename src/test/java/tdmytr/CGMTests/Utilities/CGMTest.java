package tdmytr.CGMTests.Utilities;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import tdmytr.CGMAutomationFramework.Pages.LoginPage;
import tdmytr.CGMAutomationFramework.Selenium.Driver;

public class CGMTest
{
    @BeforeSuite
    public void Init()
    {
        Driver.Initialize();

        LoginPage.GoTo();
        LoginPage.LoginAs("g3his").WithPassword("g3his").Login();
    }

    @AfterSuite
    public void Cleanup() {
        Driver.Close();
    }
}
