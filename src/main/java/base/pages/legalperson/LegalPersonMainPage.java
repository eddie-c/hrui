package base.pages.legalperson;

import base.pages.CommonPage;
import base.pages.ognization.OgnizationMainPage;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.util.List;

public class LegalPersonMainPage {
    private final WebDriver driver;
    public LegalPersonMainPage(WebDriver driver) {
        this.driver = driver;
    }
    //新建按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"operation\")]//span[contains(text(),\"新建\")]")
    WebElement createBtn;
    //导出按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"operation\")]//span[contains(text(),\"导出\")]")
    WebElement exportBtn;
    //删除按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"operation\")]//span[contains(text(),\"删除\")]")
    WebElement deleteBtn;
    @FindBy(how=How.XPATH,using="//i[@class=\"el-icon-search\"]")
    WebElement searchBtn;

    //列表全选框
    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__header\"]//th[1]")
    WebElement selectAllCheckBox;
    //搜索输入框
    @FindBy(how=How.XPATH,using="//*[contains(@class,\"search\")]//input")
    WebElement searchInputBox;

    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private WebElement loaingMask;

    @FindBy(how= How.XPATH,using="//table[@class=\"el-table__body\"]//tr")
    private List<WebElement> searchResults;

//    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//input[@type=\"checkbox\"]")
    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//label[@class=\"el-checkbox\"]")
    private List<WebElement> resultCheckboxs;

    public void gotoCreatePage(){
//        Tools.sleep(1);
//        new WebDriverWait(this.driver, 30).until(
//                ExpectedConditions.invisibilityOf(loaingMask));
////                ExpectedConditions.elementToBeClickable(btnCreateOrg));
        CommonPage.waitingForLoaing(driver);
        createBtn.click();
    }

    public void downloadAll(){
//        Tools.sleep(1);
//        new WebDriverWait(this.driver, 30).until(
//                ExpectedConditions.invisibilityOf(loaingMask));
        CommonPage.waitingForLoaing(driver);
        exportBtn.click();
    }

    public void downloadOnePage(){
//        Tools.sleep(1);
//        new WebDriverWait(this.driver, 30).until(
//                ExpectedConditions.invisibilityOf(loaingMask));
        CommonPage.waitingForLoaing(driver);
        selectAllCheckBox.click();
        exportBtn.click();
    }

    public void search(String searchTxt){
        CommonPage.waitingForLoaing(driver);
        searchInputBox.clear();
        searchInputBox.sendKeys(searchTxt);
        searchInputBox.sendKeys(Keys.ENTER);
        searchBtn.click();
    }

    public int getSearchResultCount(){
        return searchResults.size();
    }


    public void deleteLegalPersonByName(String name){
        //新建页面后，必须得先跳转到其他页面，再回来，搜索结果中才有新建的法人！！好烦！
        CommonPage.gotoPage(driver,GlobalVars.YC_HR_ORG_MANAGE_PAGE_URL);
        //办法试了几个，还不如睡一秒来的稳
        Tools.sleep(1);
        OgnizationMainPage omp = PageFactory.initElements(driver,OgnizationMainPage.class);
        omp.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver,LegalPersonMainPage.class);
        lpmp.search(name);
        resultCheckboxs.get(0).click();
        deleteBtn.click();
        //弹出删除确认窗口
        CommonPage.confirm();
    }

}
