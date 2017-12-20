package base.pages.ognization;

import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OgnizationMainPage {
    final WebDriver driver;

    @FindBy(how = How.CLASS_NAME,using="page--title")
    public WebElement pageTitle;

    public OgnizationMainPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle() {
        return pageTitle.getText().replaceAll(" ","");
    }

    public void gotoLegalPersonPage(){
        driver.get(GlobalVars.YC_LEGAL_PERSON_MAIN_PAGE_URL);
    }

}
