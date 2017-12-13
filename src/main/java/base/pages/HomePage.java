package base.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
    @FindBy(how= How.CLASS_NAME,using="user")
    private WebElement lbl_username;

    public String getName(){
        return lbl_username.getText().replaceAll(" ","");
    }
}
