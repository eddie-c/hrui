package base.page.jobPosition;

import base.pages.CommonPage;
import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CreatePositionPage {
    @FindBy(how = How.CLASS_NAME,using="page--title")
    WebElement pageTitle;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"edit-jobName\")]/input")
    WebElement positionName;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"baseinfo-level\")]")
    WebElement jobLevelDropdown;

    @FindBy(how=How.XPATH,using="//li[contains(@autotest,\"baseinfo-level\")]")
    List<WebElement> jobLevelDropdownItems;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"baseinfo-position\")]")
    WebElement parentPosition;

//    //上级职位选择后在页面上的展示文本
//    @FindBy(how=How.XPATH,using="//*[@class=\"m-dialog-select__choose-list\"]/span/span[1]")
//    WebElement parentPositionUI;
//
//    //职务选择后在页面上的展示文本
//    @FindBy(how=How.XPATH,using="//*[@class=\"m-dialog-select__choose-list\"]/span/span[2]")
//    WebElement jobUI;

    //主要职责、衡量标准rows
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"responsibility\")]//div[@class=\"table-tr\"]")
    List<WebElement> responsibilityRows;

    //教育背景
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-education\")]/textarea")
    WebElement educationRequire;

    //工作经验
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-experiences\")]/textarea")
    WebElement experiencesRequire;

    //所需培训与资质
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-train\")]/textarea")
    WebElement trainRequire;

    //基本技能
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-knowledge\")]/textarea")
    WebElement knowledgeRequire;

    //专业技能
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-knowledge_pro\")]/textarea")
    WebElement professionalKnowledgeRequire;

    //综合技能
    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"requirements-knowledge_composite\")]/textarea")
    WebElement compositeKnowledgeRequire;

    @FindBy(how=How.XPATH,using="//input[@type=\"file\"]")
    WebElement uploadFile;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"baseinfo-job\")]")
    WebElement job;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"保存\")]")
    WebElement saveButton;


    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    WebElement msgBoxConfirm;

    private final WebDriver driver;


    public CreatePositionPage(WebDriver driver){
        this.driver = driver;
    }

    public void popupParentPositionSearchDialog(){
        parentPosition.click();
    }

    public void popupJobSearchDialog(){
        job.click();
    }


    public HashMap<String,String> createPosition(){
        /*
         *初始化输入内容
         * */
        String positionNameString = "AUTO_职位名称_"+ Tools.getRandomString(6);
        positionName.sendKeys(positionNameString);
        Tools.sleep(1);
        jobLevelDropdown.click();
        new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfAllElements(jobLevelDropdownItems));
        jobLevelDropdownItems.get(0).click();
        parentPosition.click();
        SearchPageInCreatePositionPage spicpp = PageFactory.initElements(driver,SearchPageInCreatePositionPage.class);
        spicpp.searchByCode("parentPosition","200001");
        Tools.sleep(1);
        job.click();
        spicpp.searchByCode("job","测试主管");

        //填写主要职责
        //第一行（除表头外）
        WebElement row = responsibilityRows.get(1);
        String responsibilityDescription = "职责描述_mmm";
        row.findElements(By.tagName("textarea")).get(0).sendKeys(responsibilityDescription);
        String metrics = "衡量标准_mmm";
        row.findElements(By.tagName("textarea")).get(1).sendKeys(metrics);

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String parentPositionUITxt = (String) executor.executeScript("document.getElementsByClassName('m-dialog-select__choose-tag')[0].innerText");
        String jobUITxt = (String) executor.executeScript("document.getElementsByClassName('m-dialog-select__choose-tag')[1].innerText");

        //任职资格要求
        String educationRequireTxt = "教育背景_mmm";
        String experiencesRequireTxt = "工作经验_mmm";
        String trainRequireTxt = "培训资质_mm";
        String knowledgeRequireTxt = "基本技能_mmm";
        String professionalKnowledgeRequireTxt = "专业技能_mmm";
        String compositeKnowledgeRequireTxt = "综合技能_mmm";

        educationRequire.sendKeys(educationRequireTxt);
        experiencesRequire.sendKeys(experiencesRequireTxt);
        trainRequire.sendKeys(trainRequireTxt);
        knowledgeRequire.sendKeys(knowledgeRequireTxt);
        professionalKnowledgeRequire.sendKeys(professionalKnowledgeRequireTxt);
        compositeKnowledgeRequire.sendKeys(compositeKnowledgeRequireTxt);

        uploadFile.sendKeys("c:/Users/tj/Downloads/a.xlsx");
        uploadFile.sendKeys("c:/Users/tj/Downloads/b.xlsx");

        saveButton.click();

        HashMap<String,String > result = new HashMap<String, String>();

        result.put("positionNameString",positionNameString);
        result.put("responsibilityDescription",responsibilityDescription);
        result.put("metrics",metrics);

        result.put("jobLevel","40");

        result.put("educationRequireTxt",educationRequireTxt);
        result.put("experiencesRequireTxt",experiencesRequireTxt);
        result.put("trainRequireTxt",trainRequireTxt);
        result.put("knowledgeRequireTxt",knowledgeRequireTxt);
        result.put("professionalKnowledgeRequireTxt",professionalKnowledgeRequireTxt);
        result.put("compositeKnowledgeRequireTxt",compositeKnowledgeRequireTxt);

        saveButton.click();
        msgBoxConfirm.click();
        return result;
    }
}
