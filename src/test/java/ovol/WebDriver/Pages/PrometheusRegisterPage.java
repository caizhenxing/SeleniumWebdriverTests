package ovol.WebDriver.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusRegisterPage {
    WebDriver browserDriver;
    WebElement signInButton;
    WebElement submitInButton;
    String welcomeTextOnPage;

    private final String registerButton = "icon-group";
    private final String welcomeText = "title-super";
    private final String submitButton = "/html/body/div[1]/div[1]/section[2]/section/form/div[7]/button";


    public PrometheusRegisterPage(WebDriver browsweDriver) {
        this.browserDriver = browsweDriver;

    }

    public void clickButton() {
        signInButton = browserDriver.findElement(By.className(registerButton));
        signInButton.click();
    }

    public void clickSubmitButton() {
        submitInButton = browserDriver.findElement(By.xpath(submitButton));
        submitInButton.click();
    }
    /*public void checkWelcome(){
        welcomeTextOnPage = browserDriver.findElement(By.className(welcomeText)).getText();
        Assert.assertEquals(welcomeTextOnPage, "Ласкаво просимо!");
    }*/
}
