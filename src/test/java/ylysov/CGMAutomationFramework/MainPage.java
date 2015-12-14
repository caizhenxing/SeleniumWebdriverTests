package ylysov.CGMAutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ylysov on 11.12.2015.
 */
public class MainPage {

    WebDriver driver;
    WebElement menuList;
    WebElement landingPageOption;

    final String menuListLink = "//a[@class='menu-link ng-binding']";
    final String landingPageOptionLink = "//a[@class='menu-item ng-binding ng-scope cgm-truncation']";


    public MainPage (WebDriver driver){
        this.driver = driver;
    }

//    public Boolean isAtMainPage(){
//        String mainPageTitle = driver.getTitle();
//        if (mainPageTitle.contains("CGM G3 - Clinical Information System"));
//        return true;
//
//    }

    public MainPage clickMenu(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(menuListLink)));

        menuList = driver.findElement(By.xpath(menuListLink));
        menuList.click();
        return this;
    }

    public MainPage clickLandingPage(){
        landingPageOption = driver.findElement(By.xpath(landingPageOptionLink));
        landingPageOption.click();
        return this;
    }

}
