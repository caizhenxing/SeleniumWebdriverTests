package CGMTests.Tests.ovol.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by ovo on 28.12.2015.
 */
public class WDAutoCompleTest {
    static WebDriver driver = null;
    static String URL = "http://www.google.com/";
    static String SEARCH_FOR = "java webdriver api";
    static String TYPE_SEARCH_TEXT = "java webdrii";
    public static void main(String[] args) throws Exception {
        //Launch the browser with the URL provided.
        launchURL();

        //Enter the searchText.
        WebElement webElement = driver.findElement(By.id("gbqfq"));
        webElement.sendKeys(TYPE_SEARCH_TEXT);
        webElement.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(1000);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='sbsb_a']/ul/li"));
        int i=1;
        for(WebElement webElementLiList : list){
            if(!(i<=list.size())) break;
            WebElement webElementLi = webElementLiList.findElement(By.xpath("//div[@class='sbsb_a']/ul/li["+i+"]/div/div[2]"));
            String text = webElementLi.getText();
            if(text.equalsIgnoreCase(SEARCH_FOR)){
                System.out.println("Search String :: "+text);
                webElementLi.click();
                break;
            }

            i++;
        }

        //Close the browser & webdriver
        quitDriver();
    }

    public static void launchURL() throws InterruptedException{
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        Thread.sleep(1000);
    }

    public static void quitDriver() throws InterruptedException{
        Thread.sleep(5000);
        driver.close();
        driver.quit();
    }

}
