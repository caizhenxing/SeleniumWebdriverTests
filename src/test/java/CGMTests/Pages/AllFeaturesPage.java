package CGMTests.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AllFeaturesPage extends WebPageBase {

   // private WebElement landingPageButton = super.androidDriver.findElement(By.xpath("//a[contains(.,'Landing Page')]"));

    public LandingPage clickLandingPageButton(){
        WebElement landingPageButton = super.driver.findElement(By.xpath("//a[contains(.,'Landing Page')]"));
        landingPageButton.click();
        return new LandingPage();
    }
}
