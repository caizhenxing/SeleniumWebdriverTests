package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

/**
 * Created by ylysov on 11.12.2015.
 */
public class LandingPage {

    WebDriver driver;
    WebElement episodeInput;
    WebDriverWait wait;
    WebDriverWait wait2;
    List<WebElement> searchResults;

    int sizeResults;
    int selectResult;

    public LandingPage (WebDriver driver){
        this.driver = driver;
    }


    final String episodeInputLink = "//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']";
    final String searchResultsLink = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']";

    public  LandingPage enterEpisode(String s1){
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(episodeInputLink)));
        episodeInput = driver.findElement(By.xpath(episodeInputLink));
        episodeInput.click();
        episodeInput.sendKeys(s1);

        wait2 = new WebDriverWait(driver, 15);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultsLink)));

        return this;

    }

    public  LandingPage selectTopSearchResult() throws InterruptedException{
        Thread.sleep(3000);
        searchResults = driver.findElements(By.xpath(searchResultsLink));
        searchResults.get(0).click();
        return this;
    }
    public  LandingPage selectRandomSearchResult() throws InterruptedException{
        Thread.sleep(3000);
        searchResults = driver.findElements(By.xpath(searchResultsLink));
        sizeResults = searchResults.size();

        Random generator = new Random();
        selectResult=generator.nextInt(sizeResults);
        searchResults.get(selectResult).click();
        return this;
    }

}
