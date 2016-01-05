package ylysov.grid1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import ylysov.Pages.EpisodePage;
import ylysov.Pages.LandingPage;
import ylysov.Pages.LoginPage;
import ylysov.Pages.MainPage;
import Nhrytsko.WebDriver.WrappedDriver.ConfigProvider;
import org.testng.annotations.Test;

/**
 * Created by ylysov on 29.12.2015.
 */
public class ParallelTestsForGrid extends TestBaseGrid {
    WebElement searchBox;
    WebElement searchButton;
    WebElement searchResult;

    @Test
    public void t1VerifySearchIsPresent() {
        searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.isDisplayed();
    }


    @Test
    public void t2StartSearch() {
        searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys("selenium");
        searchButton = driver.findElement(By.xpath("//button[@name='btnG']"));
        searchButton.click();
    }

    @Test
    public void t3NavigateToSearchResultPage() {
        searchResult = driver.findElement(By.xpath("/html/body/div/div[5]/div[4]/div[7]/div[1]/div[3]/div/div[2]/div[2]/div/div/ol/div/div[4]/div/h3/a"));
        searchResult.click();
    }

    @Test
    public void t4DisplayTitle() {
        String title = driver.getTitle();
        System.out.println("The page title is: " + title);

    }
}