package ylysov.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ylysov.grid1.WebDriverFactory;

public class EpisodePage extends PageBase2 {

    @FindBy(name = "/his/epr/timeline")
    @CacheLookup
    private WebElement timelineTab;

    public EpisodePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(super.driver, this);
    }

    public EpisodePage selectTimelineTab(){
        WebDriverFactory.waitForElement(this.timelineTab);
        timelineTab.click();
        return this;
    }
}
