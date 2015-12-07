package ylysov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ylysov on 04.12.2015.
 */
public class LoginPage {

    WebDriver driver;
    WebElement emailInput;
    WebElement passwordInput;
    WebElement submitButton;

     LoginPage (WebDriver driver){
        this.driver = driver;
    }

    private final String emailInputLink = "email";
    private final String passwordInputLink = "password";
    private final String submitButtonLink = "submit";
    private final String errorMessageLink = "//html/body/div[1]/div[1]/section[2]/section/form/div[2]";


    public LoginPage fillLoginValues(String s1, String s2){
        emailInput = driver.findElement(By.id(emailInputLink));
        emailInput.sendKeys(s1);
        passwordInput = driver.findElement(By.id(passwordInputLink));
        passwordInput.sendKeys(s2);
        return this;
    }

    public void clickSubmitButton(){
        submitButton = driver.findElement(By.id(submitButtonLink));
        submitButton.click();
    }
    public String getLoginPageTitle(){
        String title = driver.getTitle();
        return title;
    }

    public LoginPage findErrorMessage(){

        Boolean isErrorMessagePresent = driver.findElements(By.xpath(errorMessageLink)).size()!= 0;

        if (isErrorMessagePresent == true) {
            System.out.println("Error Message Is Present");
        }
        else {
            System.out.println("Error Message Is Not Present");
        }
        return this;
    }

}


