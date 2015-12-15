package tdmytr.CGMAutomationFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tdmytr.CGMAutomationFramework.Selenium.Driver;
import tdmytr.CGMAutomationFramework.Workflow.LoginCommand;

public class LoginPage
{
    public static void GoTo()
    {
        Driver.instance.navigate().to(Driver.BaseAddress() + "login.html");
    }

    public static LoginCommand LoginAs(String userName)
    {
        return new LoginCommand(userName);
    }

    public static boolean IsAt()
    {
        WebElement loginButton = Driver.instance.findElement(By.id("btnLogin"));
        return loginButton != null;
    }
}
