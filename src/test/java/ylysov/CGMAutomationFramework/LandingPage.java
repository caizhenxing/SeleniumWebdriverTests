package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ylysov on 11.12.2015.
 */
public class LandingPage {

    WebDriver driver;
    WebElement episodeInput;
    WebDriverWait wait;

    public LandingPage (WebDriver driver){
        this.driver = driver;
    }


    final String episodeInputLink = "//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']";

    public  LandingPage enterEpisode(String s1) {

        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(episodeInputLink)));
        episodeInput = driver.findElement(By.xpath(episodeInputLink));
        episodeInput.sendKeys(s1, Keys.RETURN);
        return this;

    }

}
