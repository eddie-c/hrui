package base.pages.dataservice;

import base.pages.CommonPage;
import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OrderDinnerPage {

    WebDriver driver;

    @FindBy(how= How.CLASS_NAME,using="el-icon-plus")
    WebElement createBtn;

    @FindBy(how= How.CLASS_NAME,using="el-icon-download")
    public WebElement importBtn;

    @FindBy(how= How.CLASS_NAME,using = "el-icon-upload2")
    public WebElement exportBtn;

    @FindBy(how= How.CLASS_NAME,using = "el-icon-delete")
    public WebElement deleteBtn;

    @FindBy(how=How.XPATH,using="//i[@class=\"el-icon-search\"]")
    WebElement searchBtn;

    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]/table//tr//label[@class=\"el-checkbox\"]")
    private List<WebElement> resultCheckboxs;

    //搜索输入框
    @FindBy(how=How.XPATH,using="//*[contains(@class,\"search\")]//input")
    WebElement searchInputBox;

    //列表全选框
    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__header-wrapper\")]/table//th[1]")
    WebElement selectAllCheckBox;

    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]//tr")
    private List<WebElement> searchResults;

    public OrderDinnerPage(WebDriver driver){
        this.driver = driver;
    }

    public void gotoCreatePage(){
        createBtn.click();
        CommonPage.waitingForLoaing(driver);
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

    public void deleteFirstRecord(WebDriver driver){
        CommonPage.deleteFirstRecord(driver);
    }

    public void search(String text){
        CommonPage.search(driver,text);
    }

    public HashMap<String,String> getFirstRowInfo(){
        WebElement firstrow = searchResults.get(0);
        HashMap<String,String> result = new HashMap<String, String>();
        List<String> rowinfoParams = Arrays.asList(
                "district", "name", "goodName", "goodType","price","unit"
        );
        for(int i=0;i<rowinfoParams.size();i++){
            String param = rowinfoParams.get(i);
            result.put(param,
                    firstrow.findElement(By.className("autotest-"+param)).getText());
        }
        return result;
    }


}
