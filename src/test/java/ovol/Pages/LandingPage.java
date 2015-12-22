package ovol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ovol.Wrapper.BrowserUsage;
import ovol.Wrapper.UsingConfigData;

import java.io.IOException;

/**
 * Created by ovo on 22.12.2015.
 */
public class LandingPage extends StartPage {

    private WebDriver driver;
    LandingPage landingPage;

    public LandingPage(){
        this.driver = super.driver;
    }

    @FindBy(xpath = "//input[@aria-autocomplete='list']")
    @CacheLookup
    private static WebElement searchField;

    public LandingPage searchForPatient() throws IOException {
        BrowserUsage.driverElementWaiter(searchField);
        searchField.click();
        searchField.sendKeys(UsingConfigData.getPatientData());
        return this;
    }
}
