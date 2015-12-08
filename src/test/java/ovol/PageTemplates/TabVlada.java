package ovol.PageTemplates;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by ovo on 08.12.2015.
 */
public class TabVlada {
    WebDriver browserDriver;
    WebElement ZikTabVlada;
    private final String tabZikVlada = "body > div >" +
            " div:nth-child(6) > div > div > div > div.level2 >" +
            " ul > li:nth-child(4) > a";

    public TabVlada (WebDriver browserDriver){
        this.browserDriver = browserDriver;
    }

    public void clickOnTab (){
        ZikTabVlada = browserDriver.findElement(By.cssSelector(tabZikVlada));
        ZikTabVlada.click();
    }


}
