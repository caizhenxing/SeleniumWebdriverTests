package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ylysov on 22.12.2015.
 */
public class EpisodePage extends PageBase {

    private WebDriver driver;

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage() {
        this.driver = super.driver;
    }

    public EpisodePage selectTimelineTab(){
        RemoteBrowser.waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
