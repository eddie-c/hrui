package base.pages.legalperson;

import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LegalPersonMainPage {
    private final WebDriver driver;
    public LegalPersonMainPage(WebDriver driver) {
        this.driver = driver;
    }
    //新建按钮
    @FindBy(how= How.XPATH,using="//*[@class=\"operation\"]//span[contains(text(),\"新建\")]")
    WebElement createBtn;
    //导出按钮
    @FindBy(how= How.XPATH,using="//*[@class=\"operation\"]//span[contains(@text(),\"导出\")]")
    WebElement exportBtn;
    //删除按钮
    @FindBy(how= How.XPATH,using="//*[@class=\"operation\"]//span[contains(@text(),\"导出\")]")
    WebElement deleteBtn;

    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private WebElement loaingMask;

    public void gotoCreatePage(){
        Tools.sleep(1);
        new WebDriverWait(this.driver, 30).until(
                ExpectedConditions.invisibilityOf(loaingMask));
//                ExpectedConditions.elementToBeClickable(btnCreateOrg));
        createBtn.click();
    }
}
