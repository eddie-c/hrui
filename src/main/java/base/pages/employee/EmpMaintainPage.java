package base.pages.employee;

import base.pages.CommonPage;
import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;

public class EmpMaintainPage {
    final WebDriver driver;
    //新建按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"buttons\")]//span[contains(text(),\"新建\")]")
    WebElement createBtn;
    //导入按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"buttons\")]//span[contains(text(),\"导入\")]")
    WebElement importBtn;
    //导出按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"buttons\")]//span[contains(text(),\"导出\")]")
    WebElement exportBtn;
    //删除按钮
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"buttons\")]//span[contains(text(),\"删除\")]")
    WebElement deleteBtn;
    @FindBy(how= How.XPATH,using="//*[contains(@class,\"buttons\")]//span[contains(text(),\"员工履历导出\")]")
    WebElement expExportBtn;
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"search\")]//input")
    WebElement searchText;
    @FindBy(how=How.XPATH,using="//i[@class=\"el-icon-search\"]")
    WebElement searchBtn;

    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private WebElement loaingMask;

    @FindBy(how= How.XPATH,using="//table[@class=\"el-table__body\"]//tr")
    private List<WebElement> searchResults;

    //    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//input[@type=\"checkbox\"]")
    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//label[@class=\"el-checkbox\"]")
    private List<WebElement> resultCheckboxs;

    public EmpMaintainPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,WebElement> getColumnsFromRow(WebElement row){
        HashMap<String,WebElement> columns = new HashMap<String, WebElement>();
        WebElement name = row.findElement(By.xpath("//td[contains(@class,\"tu-name\")]"));
        columns.put("name",name);
        return columns;
    }

    public void searchByUserId(String userid){
        searchText.sendKeys(userid);
        searchBtn.click();
//        Tools.sleep(3);
        CommonPage.waitingForLoaing(driver);
        gotoFirstRecord();
    }

    public void gotoFirstRecord(){
//        WebElement firstResult = resultCheckboxs.get(0);
        WebElement firstRow = searchResults.get(1);
        HashMap<String,WebElement> columns = getColumnsFromRow(firstRow);
        WebElement name = columns.get("name");
        String s = name.getText();
        System.out.println(s);
        Actions action = new Actions(driver);
        action.moveToElement(name).doubleClick().build().perform();
        CommonPage.waitingForLoaing(driver);
    }


}
