package MobileAndroidTests.ylysov;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LandingPage extends PageBase {

    String newstring = "xaxaxaxa";

    String emailButtonId = "am.sunrise.android.calendar:id/button_connect_with_email";

    String emailButtonxpath = "//*[@bounds='[404,972][644,1076]']";

    String facebookButtonId = "am.sunrise.android.calendar:id/button_connect_with_facebook";
    String googlePlusButtonId = "am.sunrise.android.calendar:id/button_connect_with_google_plus";

    String backPlusButtonId = "android:id/up";

    public LandingPage(RemoteWebDriver androidDriver) {super(androidDriver); }

    public LandingPage clickConnectWithEmail() {
//        androidDriver.findElement(By.xpath(emailButtonxpath)).click();
        androidDriver.findElement(By.id(emailButtonId)).click();
        return new LandingPage(androidDriver);
    }

    public LandingPage clickConnectWithFacebook() {
        androidDriver.findElement(By.xpath(facebookButtonId)).click();
        return new LandingPage(androidDriver);
    }

    public LandingPage clickConnectGoogle() {
        androidDriver.findElement(By.xpath(googlePlusButtonId)).click();

        return new LandingPage(androidDriver);
    }

    public LandingPage clickBackButton() {
        androidDriver.findElement(By.id(backPlusButtonId)).click();
        return new LandingPage(androidDriver);
    }
}