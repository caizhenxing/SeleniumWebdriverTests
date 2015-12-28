package ylysov.InteractiveControlsFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ylysov on 22.12.2015.
 */
public class DropdownList {

    private WebDriver driver;

    @FindBy(id =  "select2-drop-maskselect2-drop-mask")
    @CacheLookup
    private WebElement dropdown;

    String OptionValue = "Option 3";

    public DropdownList(){this.driver = driver ;}

    public DropdownList selectValueFromList(){
                                               //Selecting value from drop down using visible text
    Select dropdown2 = new Select(dropdown);
        dropdown2.selectByVisibleText(OptionValue);
          return this;
}
}
