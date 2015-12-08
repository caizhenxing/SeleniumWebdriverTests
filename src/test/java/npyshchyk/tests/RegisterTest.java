package npyshchyk.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by nmyrosh on 07.12.2015.
 */
public class RegisterTest {

    WebDriver driver;
    private final static String registerLink = "http://edx.prometheus.org.ua/register";


    @BeforeSuite
    public void setUp(){
        this.driver = new FirefoxDriver();
    }

    @Test
    public void navigateToRegisterPage(){
        this.driver.navigate().to(registerLink);
        String welcomeMessage = driver.findElement(By.xpath("//span[@class='title-super']")).getText();

        Assert.assertEquals(welcomeMessage, "ЛАСКАВО ПРОСИМО!", "You are now on Registration Page!");
    }

    @AfterSuite
    public void tearDown(){
        this.driver.close();
    }
}
