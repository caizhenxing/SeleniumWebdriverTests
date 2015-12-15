package npyshchyk.pages;

import Nhrytsko.WebDriver.Pages.MainPage;
import Nhrytsko.WebDriver.Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by nmyrosh on 14.12.2015.
 */
public class CGMLoginPage extends PageBase {
    static WebElement usernameWebElement;
    static WebElement passwordWebElement;
    static WebElement submitButton;

    public CGMLoginPage(WebDriver driver) {
        super(driver);
    }

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
