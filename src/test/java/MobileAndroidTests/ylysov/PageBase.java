package MobileAndroidTests.ylysov;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.HashMap;

/**
 * Created by ylysov on 21.01.2016.
 */
public class PageBase {
    protected RemoteWebDriver androidDriver;

    public PageBase(RemoteWebDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public void scrollPageUp() {
        JavascriptExecutor js = (JavascriptExecutor) androidDriver;
        HashMap<String, Double> swipeObject = new HashMap<String, Double>();
        swipeObject.put("startX", 0.50);
        swipeObject.put("startY", 0.95);
        swipeObject.put("endX", 0.50);
        swipeObject.put("endY", 0.01);
        swipeObject.put("duration", 3.0);
        js.executeScript("mobile: swipe", swipeObject);
    }
}
