package ovol.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ovol.Wrapper.UsingConfigData;

import java.io.IOException;

/**
 * Created by ovo on 22.12.2015.
 */
public class StartPage {
    WebDriver driver;
    MainPage mainPage;
    LoginPage loginPage;




    public StartPage (){

    }

    public StartPage (WebDriver driver){
        this.driver = driver;
    }
    public MainPage logInBy(String userName, String userPassword)throws IOException{
        goToLoginPage().enterLogin(userName).enterPassword(userPassword).clickButton();
        this.mainPage = new MainPage();
        PageFactory.initElements(this.driver, mainPage);
        return mainPage;

    }

    private  LoginPage goToLoginPage(){
        try {
            this.driver.navigate().to(UsingConfigData.getPageUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.loginPage = new LoginPage();
        PageFactory.initElements(this.driver, loginPage);
        return loginPage;
    }
}
