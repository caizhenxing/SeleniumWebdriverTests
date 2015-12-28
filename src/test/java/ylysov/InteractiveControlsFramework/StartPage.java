package ylysov.InteractiveControlsFramework;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ylysov on 22.12.2015.
 */
public class StartPage {

    private WebDriver driver;

//    @FindBy(xpath =  "//div[contains(.,' Dropdown List ')]")  // not working (

    @FindBy(xpath =  "/html/body/div[2]/div[3]/div[1]/div[2]/div/ul/li[4]/a/div/div")
    @CacheLookup
    private WebElement dropdownList;

   public StartPage(){this.driver = driver ;}

    public StartPage selectDropdownList(){
        RemoteBrowser.waitForElement(dropdownList);
        dropdownList.click();
        return this;
    }
}
