package MobileIOSTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by ylysov on 2/10/16.
 */
public class IOSTests extends IOSTestBase {

    @Test
    public void enterValues() {

        JavascriptExecutor js = (JavascriptExecutor) iosDriver;
        HashMap<String, Double> tapObject = new HashMap<String, Double>();
        tapObject.put("x", (double) 298); // in pixels from left
        tapObject.put("y", (double) 103); // in pixels from top
        js.executeScript("mobile: tap", tapObject);

        iosDriver.findElement(By.name("Delete")).click();
        iosDriver.findElement(By.name("Delete")).click();
        iosDriver.findElement(By.name("Delete")).click();
        iosDriver.findElement(By.name("2")).click();
        iosDriver.findElement(By.name("5")).click();
        iosDriver.findElement(By.name("0")).click();
        iosDriver.findElement(By.name("20%")).click();
    }

}
