package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

/**
 * Created by ylysov on 11.12.2015.
 */
public class LandingPage {

    WebDriver driver;
    WebElement episodeInput;

    public LandingPage (WebDriver driver){
        this.driver = driver;
    }


    final String episodeInputLink = "/html/body/div[2]/div/input";

    public  LandingPage enterEpisode(String s1) {
        episodeInput = driver.findElement(By.xpath(episodeInputLink));
        episodeInput.sendKeys(s1, Keys.RETURN);
        return this;

    }

}
