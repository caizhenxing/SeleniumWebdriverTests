package CGMTests.Pages;

import WrappedDriver.RemoteBrowser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class EpisodePage extends WebPageBase {

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage selectTimelineTab(){
        RemoteBrowser.getInstance().waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
