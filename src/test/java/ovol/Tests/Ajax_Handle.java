package ovol.Tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by ovo on 29.12.2015.
 */
public class Ajax_Handle {
    WebDriver driver = new FirefoxDriver();
    @BeforeTest
    public void setup() throws Exception {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://www.google.com");
    }
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit(); } //Data provider Is used for supplying 2 different values to Search_Test method.
    @DataProvider(name="search-data")
    public Object[][] dataProviderTest(){
        return new Object[][]{{"selenium webdriver tutorial"},{"auto s"}};
    }
    @Test(dataProvider="search-data")
    public void Search_Test(String Search){
        driver.findElement(By.xpath("//input[contains(@class,'gsfi lst-d-f')]")).clear();
        driver.findElement(By.xpath("//input[contains(@class,'gsfi lst-d-f')]")).sendKeys(Search);
        int i=1;
        int j=i+1;
        try{ //for loop will run till the NoSuchElementException exception.
            for(i=1; i<j;i++) { //Value of variable i Is used for creating xpath of drop list's different elements.
                String suggestion = driver.findElement(By.xpath("//*[@id='gsr']/table/tbody/tr[1]/td[2]/table/tbody/tr["+i+"]/td/div/table/tbody/tr/td[1]/span")).getText();
                System.out.println(suggestion); j++;
            }
        }catch(Exception e){//Catch block will catch and handle the exception.
            System.out.println("***Please search for another word***");
            System.out.println();
        }
    }
}
