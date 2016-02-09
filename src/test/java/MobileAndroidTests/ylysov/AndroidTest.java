package MobileAndroidTests.ylysov;

import MobileAndroidTests.AndroidTestBase;
import org.testng.annotations.Test;

/**
 * Created by ylysov on 09.02.2016.
 */
public class AndroidTest extends AndroidTestBase {   //ylysov.AndroidTest

    @Test
    public void connectWithEmail()
    {
        new LandingPage(androidDriver).clickConnectWithEmail();
    }


    @Test
    public void returnBack()    { new LandingPage(androidDriver).clickBackButton(); }
}

