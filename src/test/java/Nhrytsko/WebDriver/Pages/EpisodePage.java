package Nhrytsko.WebDriver.Pages;

import Nhrytsko.WebDriver.WrappedDriver.RB;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EpisodePage extends PageBase {

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage selectTimelineTab(){
        RB.waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
