package tdmytr.CGMAutomationFramework.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tdmytr.CGMAutomationFramework.Selenium.Driver;

public class BasePage
{
    public static boolean IsAt()
    {
        WebElement userImage = Driver.instance.findElement(By.className("user-image"));
        return userImage != null;
    }

    public static void Logout()
    {
        WebElement userInfo = Driver.instance.findElement(By.className("user-info"));
        userInfo.click();
        WebElement userInfoDropDown = Driver.instance.findElement(By.className("cgm-dropdown-menu"));
        WebElement logoutLink = userInfoDropDown.findElement(By.xpath("/html/body/hx-feature-view-port/div/cgm-shell/div/cgm-shell-header/div/div/cgm-shell-account-menu/div/div[3]/a[4]"));
        logoutLink.click();
    }
}
