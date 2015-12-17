package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.Random;

/** trying to push
 * Created by ylysov on 17.12.2015.
 */
public class LandingPage extends PageBase {

    private WebDriver driver;

    @FindBy(xpath = "//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']")
    @CacheLookup
    private WebElement episodeInput;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
    @CacheLookup
    private List<WebElement> searchResults;

    int resultsListSize;
    int selectFromList;

    public LandingPage() { this.driver = super.driver;}

    public LandingPage enterEpisode(String patientName) {
        RemoteBrowser.waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(patientName);
        RemoteBrowser.waitForAllElements(searchResults);
        return this;
    }
    public LandingPage selectTopSearchResult() {
        searchResults.get(0).click();
        return this;
    }
    public LandingPage selectRandomSearchResult(){
        resultsListSize = searchResults.size();
        Random generator = new Random();
        selectFromList = generator.nextInt(resultsListSize);
        this.searchResults.get(selectFromList).click();
        return this;
    }
}
