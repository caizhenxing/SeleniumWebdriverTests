package adym;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        WebDriverWait wait = new WebDriverWait(driver,100);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("nav-global-01")));


        WebElement courseButton = driver.findElement(By.className("nav-global-01"));

        courseButton.click();
	/*
	WebElement ViewOfTheCourse = driver.findElement(By.className("gdlr-feature-media-ux gdlr-ux"));
	ViewOfTheCourse.getLocation();*/

        WebElement AlgorCourse =driver.findElement(By.xpath("/html/body/div/div[3]/div[1]/div/section/div/div[10]/div[2]/div/div[2]/div[1]/div[1]/h3/a"));
        AlgorCourse.click();

/*
        WebDriverWait wait2 = new WebDriverWait(driver,100);
        wait2.until(ExpectedConditions.elementToBeClickable(By.className("primary")));

        WebElement LoginDropdown =driver.findElement(By.className("primary"));
        LoginDropdown.click();*/

    }
}


