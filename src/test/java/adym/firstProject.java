package adym;

import org.apache.xpath.operations.String;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by adym on 08.12.2015.
 */
public class firstProject {
    WebDriver driver;
    @org.testng.annotations.Test
    public void homePage(){
        WebDriver driver = new FirefoxDriver();
        driver.get("http://prometheus.org.ua/");
        System.out.println("Page title is: " + driver.getTitle());
        WebElement signInElement = driver.findElement(By.xpath("/html/body/div/header/div[1]/div/div[2]/nav/ul/li[7]"));

        signInElement.click();
        System.out.println("Page title is: " +driver.getTitle());
        WebElement login= driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/section/form/div[4]/ol/li[1]/input"));

        login.sendKeys("staceydym@gmail.com");



        WebElement password = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/section/form/div[4]/ol/li[2]/input"));

        password.sendKeys("123");


        WebElement submitButton = driver.findElement(By.xpath("/html/body/div[1]/div[1]/section[2]/section/form/div[6]/button"));

        submitButton.click();
         return;
    }
}
