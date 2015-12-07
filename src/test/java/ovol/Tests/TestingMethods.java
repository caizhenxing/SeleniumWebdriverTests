package ovol.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import ovol.Values.ValuesForTest;

/**
 * Created by ovo on 07.12.2015.
 */
public class TestingMethods {

    WebDriver fireFox = new FirefoxDriver();


        ValuesForTest gotValues = new ValuesForTest();
        String forZikUrl = gotValues.getZikUrl();
        String forTabVlada = gotValues.getTabVlada();
        String forCourseraUrl = gotValues.getCourseraUrl();
        String forCourseraSignUp = gotValues.getTabCourseraSignUp();
        String forSignUpButtton = gotValues.getButtonSignUp();




    @Test
    public void firefoxWD1(){

        fireFox.navigate().to(forZikUrl);
        WebElement Vlada = fireFox.findElement(By.cssSelector(forTabVlada));
        Vlada.click();
    }

    @AfterSuite
    public void firefoxClose(){
        fireFox.close();
    }



    /*public void firefoxWD2(){
        WebDriver fireFox = new FirefoxDriver();
        fireFox.navigate().to(forCourseraUrl);
        WebElement SignUp = fireFox.findElement(By.className(forCourseraSignUp));
        WebElement SignUpButton = SignUp.findElement(By.className(forSignUpButtton));
        WebElement SignUpClick = SignUpButton.findElement(By.tagName("a"));
        SignUpClick.click();
    }*/
}
