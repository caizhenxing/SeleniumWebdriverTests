package ylysov.Pages;

import Nhrytsko.WebDriver.Pages.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import ylysov.grid1.WebDriverFactory;

public class EpisodePage extends PageBase {

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage selectTimelineTab(){
        WebDriverFactory.waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
