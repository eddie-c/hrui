package base.pages;

import com.sun.org.apache.xpath.internal.res.XPATHErrorResources;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomePage {

    final WebDriver driver;
    final String HRNavTxt = "人力行政";
    final String HRModTxt = "人事系统";

    @FindBy(how= How.CLASS_NAME,using="user")
    private WebElement lbl_username;

    @FindBy(how= How.XPATH,using="//div[@class=\"nav-list\"]/div")
    List<WebElement> navlist;

    @FindBy(how = How.XPATH, using="//div[@class=\"enter-item\"]/div")
    List<WebElement> moduleEntrys;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void gotoHrNavigation(){
        for(WebElement elem:moduleEntrys){
            if (elem.getText().contains(HRNavTxt)){
                elem.click();
            }
        }
    }

    public void gotoHrModule(){
        for(WebElement elem:moduleEntrys){
            if (elem.getText().contains(HRModTxt)){
                elem.click();
            }
        }
    }
//    List[WebElement] navlist;

    public String getName(){
        return lbl_username.getText().replaceAll(" ","");
    }

    public void gotoOrgMainPage(){
        driver.get(GlobalVars.YC_HR_ORG_MAIN_PAGE_URL);
    }

    public void clickHrEntry(){

    }
}
