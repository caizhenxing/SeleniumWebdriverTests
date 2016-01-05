package ylysov.Pages;

import Nhrytsko.WebDriver.Pages.PageBase;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ylysov.grid1.WebDriverFactory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class LandingPage extends PageBase {

    @FindBy(xpath = "//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']")
    @CacheLookup
    private WebElement episodeInput;

    @FindBy(xpath = "//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")
    @CacheLookup
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@class='search-screen']")
    @CacheLookup
    private List<WebElement> searchResults2;

    int resultsListSize;
    int selectFromList;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public LandingPage enterEpisode(String patientName) {
        WebDriverFactory.waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(patientName);
//        WebDriverFactory.waitForAllElements(searchResults);
        WebDriverFactory.implicitWait(20);
        return this;
    }
    //region Vol Search Patient
    public LandingPage searchPatient() throws IOException {
        WebDriverFactory.waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(ConfigProvider.getPatientData());
        WebDriverFactory.waitForAllElements(searchResults2);
        return this;
    }
    //endregion
    public LandingPage selectTopSearchResult() {
        searchResults.get(0).click();
        WebDriverFactory.implicitWait(20);
        return this;
    }
    public LandingPage selectRandomSearchResult(){
        resultsListSize = searchResults.size();
        Random generator = new Random();
        selectFromList = generator.nextInt(resultsListSize);
        this.searchResults.get(selectFromList).click();
        return this;
    }

    public boolean searInputIsDisplayed(){
        return this.episodeInput.isDisplayed();
    }
}