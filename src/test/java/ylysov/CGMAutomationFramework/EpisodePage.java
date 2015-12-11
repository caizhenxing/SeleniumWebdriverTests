package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ylysov on 11.12.2015.
 */
public class EpisodePage {

    WebDriver driver;
    WebElement WoundDocumentation;    // name="/his/cam/woundDocumentationFeature"
    WebElement timelineTab;              // name="/his/epr/timeline"
    WebElement Medications;           // name="/his/tsm/globalOrderListFeature_MEDServiceList"
    WebElement OrdersAndWorklist;     // name="/his/tsm/globalOrderListFeature_TSMOrdersWorkList"


    public EpisodePage(WebDriver driver) {
        this.driver = driver;
    }

    final String timelineTabLink = "/his/epr/timeline";

    public EpisodePage selectTimelineTab(){
        timelineTab = driver.findElement(By.name(timelineTabLink));
        timelineTab.click();
        return this;

}

}