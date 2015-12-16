package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by ylysov on 11.12.2015.
 */
public class LandingPage {

    WebDriver driver;
    WebElement episodeInput;
    WebDriverWait wait;
    WebDriverWait wait2;
    List<WebElement> searchResults;

    public LandingPage (WebDriver driver){
        this.driver = driver;
    }


    final String episodeInputLink = "//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']";
    final String searchResultsLink = "//ul[@class='select2-results']";

    public  LandingPage enterEpisode(String s1) throws InterruptedException{
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(episodeInputLink)));
        episodeInput = driver.findElement(By.xpath(episodeInputLink));
        episodeInput.click();
        episodeInput.sendKeys(s1);

        wait2 = new WebDriverWait(driver, 15);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultsLink)));

        Thread.sleep(3000);
        searchResults = driver.findElements(By.xpath(searchResultsLink));
        searchResults.get(0).click();

        return this;

    }

}
