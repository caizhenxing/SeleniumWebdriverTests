package Nhrytsko.WebDriver.Pages;


import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 05.01.2016.
 */
public class AllFeaturesPage extends PageBase {

   // private WebElement landingPageButton = super.driver.findElement(By.xpath("//a[contains(.,'Landing Page')]"));

    public AllFeaturesPage(WebDriver driver) {super(driver);}

    public LandingPage clickLandingPageButton(){
        WebElement landingPageButton = super.driver.findElement(By.xpath("//a[contains(.,'Landing Page')]"));
        landingPageButton.click();
        return new LandingPage(RemoteBrowser.webDriverInstance());
    }
}
