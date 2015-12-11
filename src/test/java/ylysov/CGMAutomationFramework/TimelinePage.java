package ylysov.CGMAutomationFramework;

import org.openqa.selenium.WebDriver;


/**
 * Created by ylysov on 11.12.2015.
 */
public class TimelinePage {

    WebDriver driver;

    public TimelinePage(WebDriver driver) {
        this.driver = driver;
    }

//    public TimelinePage goToTimelinePage(){
//        EpisodePage Timeline = new EpisodePage(driver);
//        Timeline.navigateToTimeline();
//        return new TimelinePage(this.driver);
//    }
}
