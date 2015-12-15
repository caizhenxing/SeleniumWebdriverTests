package tdmytr.CGMAutomationFramework.Workflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tdmytr.CGMAutomationFramework.Selenium.Driver;

public class ToastMessage
{
    public static boolean IsLoginFailed()
    {
        WebElement toastMessage = Driver.instance.findElement(By.className("message-toast"));
        return toastMessage != null;
    }
}
