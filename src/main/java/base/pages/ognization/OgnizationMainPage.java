package base.pages.ognization;

import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OgnizationMainPage {
    final WebDriver driver;

    @FindBy(how = How.CLASS_NAME,using="page--title")
    public WebElement pageTitle;

    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private WebElement loaingMask;

    public OgnizationMainPage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle() {
        return pageTitle.getText().replaceAll(" ","");
    }

    public void gotoLegalPersonPage(){
        driver.get(GlobalVars.YC_LEGAL_PERSON_MAIN_PAGE_URL);
//        Tools.sleep(1);
//        new WebDriverWait(this.driver, 30).until(
//                ExpectedConditions.invisibilityOf(loaingMask));
////                ExpectedConditions.elementToBeClickable(btnCreateOrg));

    }
}
