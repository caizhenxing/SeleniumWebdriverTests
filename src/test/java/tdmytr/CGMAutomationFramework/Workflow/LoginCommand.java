package tdmytr.CGMAutomationFramework.Workflow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tdmytr.CGMAutomationFramework.Selenium.Driver;

public class LoginCommand
{
    private String userName;
    private String password;

    public LoginCommand(String userName)
    {
        this.userName = userName;
    }

    public LoginCommand WithPassword(String password)
    {
        this.password = password;
        return this;
    }

    public void Login()
    {
        WebElement loginInput = Driver.instance.findElement(By.xpath("/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[1]/div/div/input"));
        loginInput.sendKeys(userName);

        WebElement passwordInput = Driver.instance.findElement(By.xpath("/html/body/hx-include/div/div/div[2]/div/ng-include/form/div/div/div[2]/div[2]/div/div/input"));
        passwordInput.sendKeys(password);

        WebElement loginButton = Driver.instance.findElement(By.id("btnLogin"));
        loginButton.click();
    }
}
