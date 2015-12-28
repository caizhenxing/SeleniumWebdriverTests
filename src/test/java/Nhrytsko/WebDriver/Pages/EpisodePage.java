package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RemoteBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EpisodePage extends PageBase {

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public EpisodePage selectTimelineTab(){
        RemoteBrowser.waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
