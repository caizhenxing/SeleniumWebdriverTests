package ylysov.InteractiveControlsTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import ylysov.InteractiveControlsFramework.DropdownList;
import ylysov.InteractiveControlsFramework.StartPage;

/**
 * Created by ylysov on 22.12.2015.
 */
public class Tests1 extends BaseForControlsTests{

    @Test
    public void t1navigateToDropdownList(){
        StartPage startPage = new StartPage();
        PageFactory.initElements(this.driver, startPage);
        startPage.selectDropdownList();
    }

    @Test
    public void t2userCanSelectValue(){
        DropdownList dropdown = new DropdownList();
        PageFactory.initElements(this.driver, dropdown);
        dropdown.selectValueFromList();

    }
}
