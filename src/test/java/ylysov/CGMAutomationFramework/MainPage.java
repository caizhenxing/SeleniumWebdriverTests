package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ylysov on 11.12.2015.
 */
public class MainPage {

    WebDriver driver;
    WebElement menuDropdown;
    WebElement landingPageOption;

    public MainPage (WebDriver driver){
        this.driver = driver;
    }

//    public Boolean isAtMainPage(){
//        String mainPageTitle = driver.getTitle();
//        if (mainPageTitle.contains("CGM G3 - Clinical Information System"));
//        return true;
//
//    }

    final String menuDropdownInputLink = "/html/body/hx-feature-view-port/div/cgm-shell/div/cgm-shell-main-menu/div[1]/ul[1]/li/a";
    public MainPage clickMenu(){
        menuDropdown = driver.findElement(By.xpath(menuDropdownInputLink));
        menuDropdown.click();
        return this;

    }

    final String landingPageOptionLink = "/html/body/hx-feature-view-port/div/cgm-shell/div/cgm-shell-main-menu/div[1]/ul[1]/li/div/a[1]";
    public MainPage clickLandingPage(){
        landingPageOption = driver.findElement(By.xpath(landingPageOptionLink));
        landingPageOption.click();
        return this;

    }

}
