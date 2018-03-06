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

public class OrgChangeHigherPage {
    private final WebDriver driver;

    @FindBy(how= How.XPATH,using = "//input[contains(@placeholder,\"方案名称\")]")
    private WebElement adjustName;

    @FindBy(how=How.XPATH,using = "//div[contains(@class,\"el-date-editor\")]/input")
    private WebElement validateTime;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"调整原因\")]/following::div[1]//textarea")
    private WebElement whyadjust;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"调整内容\")]/following::div[1]//textarea")
    private WebElement adjustContent;

//    @FindBy(how= How.XPATH,using="//div[contains(text(),\"被拆分组织\")]/following::div[1]//span[@class=\"el-cascader__label\"]")
//    private WebElement orgDropdownlistadjustFrom;
//
//    @FindBy(how= How.XPATH,using="//div[contains(text(),\"拆分后组织\")]/following::div[1]//span[@class=\"el-cascader__label\"]")
//    private WebElement orgDropdownlistadjustTo;
    @FindBy(how= How.XPATH,using="//span[@class=\"el-cascader__label\"]")
    List<WebElement> orgDropdownlist;

    //在下拉框中选择组织后，点击此元素使下拉框失去焦点
    @FindBy(how=How.XPATH, using="//div[contains(text(),\"说明：左侧为当前组织架构，请勾选待调整部门，点击向右箭头\")]")
    private WebElement somethingNotImportant;

    /*
     *被合并组织的下拉选项
     * */
    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul")
    WebElement[] menuLevelCount;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgadjustFrom;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"自动化专用\")]")
    WebElement autoUseOrgadjustFromLevel2;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul[3]/li")
    List<WebElement> autoUseOrgadjustFromLevel3;

    //拆分组织的列表checkbox
    @FindBy(how = How.XPATH,using="//span[@aria-checked=\"mixed\"]")
    List<WebElement> orgsadjustListCheckbox;
    //拆分组织的列表
    @FindBy(how = How.XPATH,using="//div[@role=\"group\"]")
    List<WebElement> orgsadjustListParent;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgadjustTo;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"自动化拆分专用\")]")
    WebElement autoUseOrgadjustToLevel2;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'el-cascader-menus')][2]/ul[3]/li")
    List<WebElement> autoUseOrgadjustToLevel3;

    @FindBy(how = How.XPATH, using = "//i[@class=\"el-icon-arrow-right\"]/../..")
    WebElement rightArrow;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"提交生效\")]")
    WebElement submit;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"确定\")]")
    List<WebElement> confirms;

    public OrgChangeHigherPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String> adjust(String from, String to){

        HashMap<String,String> ret = new HashMap<String, String>();
        //基本信息
        String name = "AUTO_adjust_"+ Tools.getRandomString();
        adjustName.sendKeys(name);
        ret.put("adjustName",name);

        String date = Tools.getValidateDate();
        validateTime.sendKeys(date);
        //点击其他页面元素，使日期框消失
        adjustName.click();
        ret.put("validateDate",date);

        String adjustcause = Tools.getRandomString(100);
        whyadjust.sendKeys(adjustcause);
        ret.put("whyadjust",adjustcause);

        String adjustcontent = Tools.getRandomString(100);
        adjustContent.sendKeys(adjustcontent);
        ret.put("adjustContent",adjustcontent);

        ret.put("adjustFrom",from);
        ret.put("adjustTo",to);
        WebElement orgDropdownlistadjustFrom = orgDropdownlist.get(0);
        WebElement orgDropdownlistadjustTo = orgDropdownlist.get(1);
        //选择被合并组织
        orgDropdownlistadjustFrom.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgadjustFrom));
        topLevelOrgadjustFrom.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(autoUseOrgadjustFromLevel2));
        autoUseOrgadjustFromLevel2.click();

        somethingNotImportant.click();

        //选择合并目标组织

        Tools.sleep(2);

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.elementToBeClickable(orgDropdownlistadjustTo));
        orgDropdownlistadjustTo.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgadjustTo));
        topLevelOrgadjustTo.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.attributeToBe(orgsadjustListCheckbox.get(0),"class","el-checkbox__input"));
        autoUseOrgadjustToLevel2.click();

        somethingNotImportant.click();


        List<WebElement> orgsadjustFromList = orgsadjustListParent.get(0).findElements(By.xpath("//span[@class=\"el-checkbox__label\"]/span"));
        for(int i=0;i<orgsadjustFromList.size();i++){
            if(orgsadjustFromList.get(i).getText().equals(from)){
                orgsadjustFromList.get(i).click();
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
