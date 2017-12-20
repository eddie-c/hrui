package base.pages.ognization;

import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrgManagePage {

    private final WebDriver driver;

    public OrgManagePage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how= How.CLASS_NAME,using="icon--add")
    public WebElement btnCreateOrg;

    @FindBy(how= How.CLASS_NAME,using="icon--import")
    public WebElement btnImportOrg;

    @FindBy(how= How.CLASS_NAME,using = "icon--export")
    public WebElement btnExportOrg;

    @FindBy(how= How.CLASS_NAME,using = "el-icon-delete2")
    public WebElement btnDeleteOrg;

    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private WebElement loaingMask;

    public void gotoCreatePage() {
        Tools.sleep(1);
        new WebDriverWait(this.driver, 30).until(
                ExpectedConditions.invisibilityOf(loaingMask));
//                ExpectedConditions.elementToBeClickable(btnCreateOrg));
        btnCreateOrg.click();
    }

}
