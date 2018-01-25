package base.pages.ognization;

import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class OrgSplitPage {
    private final WebDriver driver;

    @FindBy(how= How.XPATH,using = "//div[contains(@class,\"el-input-name\")]/input")
    private WebElement splitName;

    @FindBy(how=How.XPATH,using = "//div[contains(@class,\"el-date-editor\")]/input")
    private WebElement validateTime;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"拆分原因\")]/following::div[1]//textarea")
    private WebElement whysplit;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"拆分内容\")]/following::div[1]//textarea")
    private WebElement splitContent;

//    @FindBy(how= How.XPATH,using="//div[contains(text(),\"被拆分组织\")]/following::div[1]//span[@class=\"el-cascader__label\"]")
//    private WebElement orgDropdownlistsplitFrom;
//
//    @FindBy(how= How.XPATH,using="//div[contains(text(),\"拆分后组织\")]/following::div[1]//span[@class=\"el-cascader__label\"]")
//    private WebElement orgDropdownlistsplitTo;
    @FindBy(how= How.XPATH,using="//span[@class=\"el-cascader__label\"]")
    List<WebElement> orgDropdownlist;

    //在下拉框中选择组织后，点击此元素使下拉框失去焦点
    @FindBy(how=How.XPATH, using="//div[contains(text(),\"说明：选择被拆分组织（可多选），再新建拆分后组织\")]")
    private WebElement somethingNotImportant;

    /*
     *被合并组织的下拉选项
     * */
    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul")
    WebElement[] menuLevelCount;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgsplitFrom;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"自动化专用\")]")
    WebElement autoUseOrgsplitFromLevel2;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul[3]/li")
    List<WebElement> autoUseOrgsplitFromLevel3;

    //拆分组织的列表checkbox
    @FindBy(how = How.XPATH,using="//span[@aria-checked=\"mixed\"]")
    List<WebElement> orgssplitListCheckbox;
    //拆分组织的列表
    @FindBy(how = How.XPATH,using="//div[@role=\"group\"]")
    List<WebElement> orgssplitListParent;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgsplitTo;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"自动化拆分专用\")]")
    WebElement autoUseOrgsplitToLevel2;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'el-cascader-menus')][2]/ul[3]/li")
    List<WebElement> autoUseOrgsplitToLevel3;

    @FindBy(how = How.XPATH, using = "//i[@class=\"el-icon-arrow-right\"]/../..")
    WebElement rightArrow;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"提交生效\")]")
    WebElement submit;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"确定\")]")
    List<WebElement> confirms;

    public OrgSplitPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String> split(String from, String to){

        HashMap<String,String> ret = new HashMap<String, String>();
        //基本信息
        String name = "AUTO_split_"+ Tools.getRandomString();
        splitName.sendKeys(name);
        ret.put("splitName",name);

        String date = Tools.getValidateDate();
        validateTime.sendKeys(date);
        //点击其他页面元素，使日期框消失
        splitName.click();
        ret.put("validateDate",date);

        String splitcause = Tools.getRandomString(100);
        whysplit.sendKeys(splitcause);
        ret.put("whysplit",splitcause);

        String splitcontent = Tools.getRandomString(100);
        splitContent.sendKeys(splitcontent);
        ret.put("splitContent",splitcontent);

        ret.put("splitFrom",from);
        ret.put("splitTo",to);
        WebElement orgDropdownlistsplitFrom = orgDropdownlist.get(0);
        WebElement orgDropdownlistsplitTo = orgDropdownlist.get(1);
        //选择被合并组织
        orgDropdownlistsplitFrom.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgsplitFrom));
        topLevelOrgsplitFrom.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(autoUseOrgsplitFromLevel2));
        autoUseOrgsplitFromLevel2.click();

        somethingNotImportant.click();

        //选择合并目标组织

        Tools.sleep(2);

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.elementToBeClickable(orgDropdownlistsplitTo));
        orgDropdownlistsplitTo.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgsplitTo));
        topLevelOrgsplitTo.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.attributeToBe(orgssplitListCheckbox.get(0),"class","el-checkbox__input"));
        autoUseOrgsplitToLevel2.click();

        somethingNotImportant.click();


        List<WebElement> orgssplitFromList = orgssplitListParent.get(0).findElements(By.xpath("//span[@class=\"el-checkbox__label\"]/span"));
        for(int i=0;i<orgssplitFromList.size();i++){
            if(orgssplitFromList.get(i).getText().equals(from)){
                orgssplitFromList.get(i).click();
            }
        }
        //
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.elementToBeClickable(rightArrow));
        rightArrow.click();
//        //提交，确认
        submit.click();
        Tools.sleep(1);
        for(int i=0;i<confirms.size();i++) {
            if(confirms.get(i).isDisplayed()){
                confirms.get(i).click();
            }
        }

        return ret;

    }
}
