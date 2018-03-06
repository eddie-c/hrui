package base.pages;

import common.Tools;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.monitor.CounterMonitor;
import java.util.List;

/*
* 对某些特别的控件，模拟出的页面
* */
public class CommonPage {
    //页面标题
    @FindBy(how = How.CLASS_NAME,using="page--title")
    WebElement pageTitle;

    @FindBy(how= How.CLASS_NAME,using="el-icon-plus")
    static WebElement createBtn;

    @FindBy(how= How.CLASS_NAME,using="el-icon-download")
    public static WebElement importBtn;

    @FindBy(how= How.CLASS_NAME,using = "el-icon-upload2")
    public static WebElement exportBtn;

    @FindBy(how= How.CLASS_NAME,using = "el-icon-delete")
    public static WebElement deleteBtn;

    @FindBy(how=How.XPATH,using="//i[@class=\"el-icon-search\"]")
    static WebElement searchBtn;

    //列表全选框
    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__header-wrapper\")]/table//th[1]")
    static WebElement selectAllCheckBox;

    //搜索输入框
    @FindBy(how=How.XPATH,using="//*[contains(@class,\"search\")]//input")
    static WebElement searchInputBox;

    @FindBy(how= How.XPATH,using="//table[@class=\"el-table__body\"]//tr")
    private static List<WebElement> searchResults;

    //    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//input[@type=\"checkbox\"]")
    @FindBy(how = How.XPATH,using="//table[@class=\"el-table__body\"]//tr//label[@class=\"el-checkbox\"]")
    private static List<WebElement> resultCheckboxs;

    //页面加载元素
    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private static WebElement loaingMask;

    public static void waitingForLoaing(WebDriver driver){
        try{
            if (loaingMask != null){
                new WebDriverWait(driver, 30).until(
                        ExpectedConditions.invisibilityOf(loaingMask));
            }
        }catch(Exception e){}
    }

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    private static WebElement msgBoxConfirm;

    public static void gotoPage(WebDriver driver,String pageurl){
        driver.get(pageurl);
        waitingForLoaing(driver);
    }

    /*
    * 点击页面空白处
    * */
    public static void clickBlankArea(WebDriver driver) {
        Actions actions = new Actions(driver);
        actions.moveByOffset(0, 0).click().build().perform();
    }

    public static void gotoCreatePage(WebDriver driver){
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.invisibilityOf(loaingMask));
        createBtn.click();
    }

    public static void gotoImportPage(WebDriver driver){
        new WebDriverWait(driver, 30).until(
                ExpectedConditions.invisibilityOf(loaingMask));
        importBtn.click();
    }

    public static void downloadAll(WebDriver driver){
        clearSearchText(driver);
        exportBtn.click();
    }

    public static void clearSearchText(WebDriver driver){
        /*
         *清空搜索框，并点击一次搜索，保证页面为全部结果
         */
        searchInputBox.clear();
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(searchBtn));
        CommonPage.waitingForLoaing(driver);
        Tools.sleep(1);
        searchBtn.click();
        CommonPage.waitingForLoaing(driver);
    }

    public static void downloadOnePage(WebDriver driver){
        clearSearchText(driver);
        selectAllCheckBox.click();
        exportBtn.click();
    }

    public static void downloadFirstRecord(WebDriver driver){
        clearSearchText(driver);
        resultCheckboxs.get(0).click();
        exportBtn.click();
    }

    public static void deleteFirstRecord(WebDriver driver){
        clearSearchText(driver);
        resultCheckboxs.get(0).click();
        deleteBtn.click();
        confirm();
    }

    public static void search(WebDriver driver,String searchTxt){
        waitingForLoaing(driver);
        searchInputBox.clear();
        searchInputBox.sendKeys(searchTxt);
        searchInputBox.sendKeys(Keys.ENTER);
        searchBtn.click();
    }

    public static void confirm(){
        msgBoxConfirm.click();
    }
}
