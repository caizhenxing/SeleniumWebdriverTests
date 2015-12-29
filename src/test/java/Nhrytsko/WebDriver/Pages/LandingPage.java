package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    @FindBy(xpath = "//ul[@class='select2-results']")
    @CacheLookup
   // private ArrayList<WebElement> searchResults2;
    private List<WebElement> searchResults3;


    int resultsListSize;
    int selectFromList;

    public LandingPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }
    public LandingPage enterEpisode(String patientName) {
        RemoteBrowser.waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(patientName);
       //        RemoteBrowser.waitForAllElements(searchResults);
        RemoteBrowser.implicitWait(10);
        return this;
    }
    //region Vol Search Patient
    public LandingPage searchPatient() throws IOException {
        RemoteBrowser.waitForElement(this.episodeInput);
        episodeInput.click();
        episodeInput.sendKeys(ConfigProvider.getPatientData());
        RemoteBrowser.waitForAllElements(searchResults3);
        return this;
    }
    //endregion
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
    public LandingPage selectExactResult() throws IOException {
        int i = 1 ;
        for(WebElement webElementLiList : searchResults3) {
            if (!(i <= searchResults3.size())) break;
            WebElement webElementLi = webElementLiList.findElement(By.xpath("//li[@class='select2-results-dept-0 " +
                    "select2-result select2-result-selectable'][" + i + "]"));
            String text = webElementLi.getText();
            if (text.equalsIgnoreCase(ConfigProvider.getPatientEpisode())) {
                System.out.println("Search String :: " + text);
                webElementLi.click();
                break;
            }

            i++;
            System.out.println(searchResults3);

        }
        return this;
    }

    public boolean searInputIsDisplayed(){
        return this.episodeInput.isDisplayed();
    }
}
