package ovol.PageTemplates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 08.12.2015.
 */
public class PrometheusRegisterPage {
    WebDriver browserDriver;
    WebElement signInButton;
    private final String registerButton = "icon-group";


    public PrometheusRegisterPage (WebDriver browsweDriver){
        this.browserDriver = browsweDriver;

    }

    public void clickButton(){
        signInButton = browserDriver.findElement(By.className(registerButton));
        signInButton.click();
    }
}
