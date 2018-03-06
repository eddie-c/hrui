package base.page.jobPosition;

import base.pages.CommonPage;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CommonFuncs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JobMaintainPage{
    //新建按钮
    @FindBy(how= How.XPATH,using="//span[contains(text(),\"新建\")]")
    WebElement createBtn;
    //导入按钮
    @FindBy(how= How.XPATH,using="//span[contains(text(),\"导出\")]")
    WebElement importBtn;
    //导出按钮
    @FindBy(how= How.XPATH,using="//span[contains(text(),\"导出\")]")
    WebElement exportBtn;
    //删除按钮
    @FindBy(how= How.XPATH,using="//span[contains(text(),\"删除\")]")
    WebElement deleteBtn;
    @FindBy(how=How.XPATH,using="//i[@class=\"el-icon-search\"]")
    WebElement searchBtn;

    //列表全选框
    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__header-wrapper\")]/table//th[1]")
    WebElement selectAllCheckBox;

    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]//tr)")
    private List<WebElement> searchResults;

    //    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//input[@type=\"checkbox\"]")
    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]/table//tr//label[@class=\"el-checkbox\"]")
    private List<WebElement> resultCheckboxs;

    //搜索输入框
    @FindBy(how=How.XPATH,using="//*[contains(@class,\"search\")]//input")
    WebElement searchInputBox;

    public void searchByJobName(String searchTxt){
        CommonPage.waitingForLoaing(driver);
        searchInputBox.clear();
        searchInputBox.sendKeys(searchTxt);
        searchInputBox.sendKeys(Keys.ENTER);
        searchBtn.click();
    }

    public HashMap<String,String> getFirstRowInfo(){
        WebElement firstrow = searchResults.get(0);
//        firstrow.findElement()
        HashMap<String,String> result = new HashMap<String, String>();
        List<String> rowinfoParams = Arrays.asList(
                "code", "name", "type", "level"
        );
        for(int i=0;i<rowinfoParams.size();i++){
            String param = rowinfoParams.get(i);
            result.put(param,
                    firstrow.findElement(By.className("autotest-"+param)).getText());
        }
        return result;
    }

    public void gotoCreatePage(){
        while(true){
            try{
                createBtn.click();
                break;
            }catch (Exception e){
                CommonPage.waitingForLoaing(driver);
            }
        }
    }

    public void downloadAll(){
        CommonPage.downloadAll(driver);
    }

    public void downloadOnePage(){
        CommonPage.downloadOnePage(driver);
    }

    public void downloadFirstRecord(){
        CommonPage.downloadFirstRecord(driver);
    }

    public int getSearchResultCount(){
        return searchResults.size();
    }


    public void deleteJobByName(String name){
        //新建页面后，必须得先跳转到其他页面，再回来，搜索结果中才有新建的法人！！好烦！
        CommonPage.gotoPage(driver, GlobalVars.YC_HR_ORG_MANAGE_PAGE_URL);
        //办法试了几个，还不如睡一秒来的稳
        Tools.sleep(1);
        CommonPage.gotoPage(driver,GlobalVars.YC_JOB_MANAGE_URL);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);
        jmp.searchByJobName(name);
        resultCheckboxs.get(0).click();
        deleteBtn.click();
        //弹出删除确认窗口
        CommonPage.confirm();
    }
    public WebDriver driver;
    public JobMaintainPage(WebDriver driver){
        this.driver = driver;
    }

}
