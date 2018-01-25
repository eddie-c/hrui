package base.pages.ognization;

import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class OrgMergePage {
    private final WebDriver driver;

    @FindBy(how= How.XPATH,using = "//div[contains(@class,\"el-input-name\")]/input")
    private WebElement mergeName;

    @FindBy(how=How.XPATH,using = "//div[contains(@class,\"el-date-editor\")]/input")
    private WebElement validateTime;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"合并原因\")]/following::div[1]//textarea")
    private WebElement whyMerge;

    @FindBy(how=How.XPATH,using = "//label[contains(text(),\"合并内容\")]/following::div[1]//textarea")
    private WebElement mergeContent;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"被合并的组织\")]/following::span[@class=\"el-cascader__label\"]")
    private WebElement orgDropdownlistMergeFrom;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"接收组织\")]/following::span[@class=\"el-cascader__label\"]")
    private WebElement orgDropdownlistMergeTo;

    /*
    *被合并组织的下拉选项
    * */
    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul")
    WebElement[] menuLevelCount;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgMergeFrom;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]//li[contains(text(),\"自动化专用\")]")
    WebElement autoUseOrgMergeFromLevel2;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][1]/ul[3]/li")
    List<WebElement> autoUseOrgMergeFromLevel3;



    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrgMergeTo;

    @FindBy(how = How.XPATH,using="//div[contains(@class,'el-cascader-menus')][2]//li[contains(text(),\"自动化专用\")]")
    WebElement autoUseOrgMergeToLevel2;

    @FindBy(how = How.XPATH, using = "//div[contains(@class,'el-cascader-menus')][2]/ul[3]/li")
//             WebElement[] autoUseOrgMergeToLevel3;
    List<WebElement> autoUseOrgMergeToLevel3;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"提交生效\")]")
    WebElement submit;

    @FindBy(how = How.XPATH, using="//span[contains(text(),\"确定\")]")
    List<WebElement> confirms;

    public OrgMergePage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String> merge(String from, String to){

        HashMap<String,String> ret = new HashMap<String, String>();
        //基本信息
        String name = "AUTO_Merge_"+ Tools.getRandomString();
        mergeName.sendKeys(name);
        ret.put("mergeName",name);

        String date = Tools.getValidateDate();
        validateTime.sendKeys(date);
        //点击其他页面元素，使日期框消失
        mergeName.click();
        ret.put("validateDate",date);

        String mergecause = Tools.getRandomString(100);
        whyMerge.sendKeys(mergecause);
        ret.put("whyMerge",mergecause);

        String mergecontent = Tools.getRandomString(100);
        mergeContent.sendKeys(mergecontent);
        ret.put("mergeContent",mergecontent);

        ret.put("mergeFrom",from);
        ret.put("mergeTo",to);
        //选择被合并组织
        orgDropdownlistMergeFrom.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgMergeFrom));
        topLevelOrgMergeFrom.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(autoUseOrgMergeFromLevel2));
        autoUseOrgMergeFromLevel2.click();


        for(int i=0;i<autoUseOrgMergeFromLevel3.size();i++){
            if(autoUseOrgMergeFromLevel3.get(i).getText().contains(from)){
                autoUseOrgMergeFromLevel3.get(i).click();
            }
        }

        //选择合并目标组织
        orgDropdownlistMergeTo.click();
        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrgMergeTo));
        topLevelOrgMergeTo.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(autoUseOrgMergeToLevel2));
        autoUseOrgMergeToLevel2.click();

//        new WebDriverWait(this.driver,30).until(
//                ExpectedConditions.visibilityOf(autoUseOrgMergeToLevel3[0]));

        for(int i=0;i<autoUseOrgMergeToLevel3.size();i++){
            if(autoUseOrgMergeToLevel3.get(i).getText().contains(from)){
                autoUseOrgMergeToLevel3.get(i).click();
            }
        }

        //提交，确认
        submit.click();
        Tools.sleep(1);
        for(int i=0;i<confirms.size();i++) {
            if(confirms.get(i).isDisplayed()){
                confirms.get(i).click();
            }
        }
//        CommonPage.confirm();
        return ret;

    }

}
