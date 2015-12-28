package ylysov.CGMTests;

import Nhrytsko.WebDriver.Tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Created by ylysov on 25.12.2015.
 */
//public class Test2 extends TestBase {
//
//    WebDriver driver;
//
//    @Test(groups = {"group2"})
//    public void allcodehere(){
//
//        WebDriverWait wait = new WebDriverWait(driver, 15);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='menu-link ng-binding']")));
//
//        WebElement menu = driver.findElement(By.xpath("//a[@class='menu-link ng-binding']"));
//        menu.click();
//
//        WebElement landingPage = driver.findElement(By.xpath("//a[@class='menu-item ng-binding ng-scope cgm-truncation']"));
//        landingPage.click();
//
//        WebDriverWait wait2 = new WebDriverWait(driver, 15);
//        wait2.until(ExpectedConditions.
//                presenceOfElementLocated(By.xpath("//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']")));
//    }
//
//    Boolean ismenupresent = driver.findElements(By.className("cgm-menu")).size()!= 0;
//
//    if (ismenupresent == true)		{ System.out.println("Menu Is Present");
//    }
//    else {
//        System.out.println("Menu Is Not Present");
//    }
//
//    WebElement menu = driver.findElement(By.xpath("//a[@class='menu-link ng-binding']"));
//    menu.click();
//
//    WebElement landingPage = driver.findElement(By.xpath("//a[@class='menu-item ng-binding ng-scope cgm-truncation']"));
//    landingPage.click();
//
//
//
//
//    WebDriverWait wait2 = new WebDriverWait(driver, 15);
//    wait2.until(ExpectedConditions.
//            presenceOfElementLocated(By.xpath("//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']")));
//
//    Boolean isSearchpresent = driver.
//            findElements(By.xpath("//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']")).size()!= 0;
//
//    if (isSearchpresent == true)		{ System.out.println("Search Is Present");
//    }
//    else {
//        System.out.println("Search Is Not Present");
//    }
//
//    WebElement episodeInput2 = driver.findElement(By.xpath("//cgm-search-field[@class='cgm-autocomplete cgm-search-field cgm-autocomplete-empty ng-valid']"));
//    episodeInput2.click();
//    episodeInput2.sendKeys("Hauser ");
//
//    WebDriverWait wait7 = new WebDriverWait(driver, 15);
//    wait7.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")));
//}
//
//
//  @Test(groups = {"group2"})
//    public void t1IsAtLoginPage(){
//        super.mainPage.clickMenuButton();
//        super.mainPage.clickLandingPageButton();
//        }

//
//
//
//}
