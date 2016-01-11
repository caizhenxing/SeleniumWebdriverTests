package npyshchyk.pages;

import Nhrytsko.WebDriver.Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CGMLoginPage extends PageBase {
    static WebElement usernameWebElement;
    static WebElement passwordWebElement;
    static WebElement submitButton;

    // method enter credentials and clicks "Submit" button
    public static void login(WebDriver driver, String userName){
        usernameWebElement = driver.findElement(By.xpath("//input[@name='userName']"));
        usernameWebElement.sendKeys(userName);

        passwordWebElement = driver.findElement(By.xpath("//input[@name='password']"));
        passwordWebElement.sendKeys(userName);

        submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();
    }

}
