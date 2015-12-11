package ylysov.CGMTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ylysov.CGMAutomationFramework.LoginPage;


/**
 * Created by ylysov on 10.12.2015.
 */
public class LoginTests extends TestOrigin {

    @Test
    public void navigateToLoginPage(){
        super.pages.goToLoginPage();
    }

    @Test
    public void loginWithValidCredentials(){

        String ValidEmailValue = "g3his";
        String ValidPasswordValue = "g3his";

        LoginPage login =  super.pages.goToLoginPage();
        login.fillEmail(ValidEmailValue).fillPassword(ValidPasswordValue).login();

        Assert.assertTrue(super.pages.isAtMainPage());

    }
}
