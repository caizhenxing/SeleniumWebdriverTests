package ovol.PageTemplates;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusRegisterPage {
    WebDriver browserDriver;
    WebElement signInButton;
   String welcomeTextOnPage;
    private final String registerButton = "icon-group";
    private final String welcomeText = "introduction";


    public PrometheusRegisterPage (WebDriver browsweDriver){
        this.browserDriver = browsweDriver;

    }

    public void clickButton(){
        signInButton = browserDriver.findElement(By.className(registerButton));
        signInButton.click();
    }
    public void checkWelcome(){
        welcomeTextOnPage = browserDriver.findElement(By.className(welcomeText)).getText();
        Assert.assertEquals(welcomeTextOnPage, "Ласкаво просимо!");
    }
}
