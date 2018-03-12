package base.page.jobPosition;

import base.pages.CommonPage;
import common.Tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class CreateJobPage {

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"edit-jobName\")]/input")
    WebElement jobName;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"edit-jobCategory\")]")
    WebElement jobTypeDropdownUI;

    @FindBy(how=How.XPATH,using="//div[contains(@autotest,\"edit-jobLevels\")]")
    WebElement jobLevelDropdownUI;

    @FindBy(how=How.XPATH,using="//li[starts-with(@autotest,\"edit-jobCategory-\")]/span")
    List<WebElement> jobTypeDropdownItems;

    @FindBy(how=How.XPATH,using="//li[starts-with(@autotest,\"edit-jobLevels-\")]/span")
    List<WebElement> jobLevelDropdownItems;

//    @FindBy(how = How.XPATH,using="//span[contains(text(),\"保存\")]")
    @FindBy(how = How.XPATH,using="//button[@autotest=\"btn-save\"]")
    WebElement saveButton;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    WebElement msgBoxConfirm;

    private final WebDriver driver;

    public CreateJobPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String> createJob(){
        /*
        *初始化输入内容
        * */
        String jobnameString = "AUTO_职务名称_"+Tools.getRandomString(6);
        jobName.sendKeys(jobnameString);
        String[] jobtypes = {"管理类","专业类","技术类","营销类"};
        String jobtype = Tools.arrayChoice(jobtypes);
        //点击职务类型下拉控件，弹出选项
        jobTypeDropdownUI.click();
        new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOfAllElements(jobTypeDropdownItems));
        for(int i=0;i<jobTypeDropdownItems.size();i++){
            WebElement item = jobTypeDropdownItems.get(i);
            if(item.getText().contains(jobtype)){
                item.click();
                break;
            }
        }
        Tools.sleep(1);
        jobLevelDropdownUI.click();

        System.out.println(jobLevelDropdownItems.size());
        int levelindex = new Random().nextInt(jobLevelDropdownItems.size()-1);
        String joblevel = jobLevelDropdownItems.get(levelindex).getText();
        Tools.sleep(1);

        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(jobLevelDropdownItems.get(levelindex)));
        jobLevelDropdownItems.get(levelindex).click();

        Tools.sleep(1);
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(saveButton));

        saveButton.click();

        HashMap<String,String> result = new HashMap<String,String>();
        result.put("name",jobnameString);
        result.put("type",jobtype);
        result.put("level",joblevel);
        msgBoxConfirm.click();
        //在点击新建以后，等待详情页面加载完毕，否则，在删除用例的时候，导致“是否保存所做更改”的弹窗出现
        CommonPage.waitingForLoaing(driver);
        return result;
    }

    public HashMap<String,String> editJob(){

        HashMap<String,String> result = new HashMap<String, String>();

        String jobType="";
        jobTypeDropdownUI.click();
        Tools.sleep(1);
        //重新选择一个职务类别
        for(int i=0;i<jobTypeDropdownItems.size();i++){
            WebElement item = jobTypeDropdownItems.get(i);
            if(!item.isSelected()){
                item.click();
                jobType = item.getText();
                break;
            }
        }

        Tools.sleep(1);

        //重新选择一个职级
        jobLevelDropdownUI.click();
        Tools.sleep(1);
        System.out.println(jobLevelDropdownItems.size());
        int levelindex = new Random().nextInt(jobLevelDropdownItems.size()-1);
        String joblevel = jobLevelDropdownItems.get(levelindex).getText();
        jobLevelDropdownItems.get(levelindex).click();

        Tools.sleep(1);
        saveButton.click();
        msgBoxConfirm.click();

        result.put("type",jobType);
        result.put("level",joblevel);
        return result;

    }


}
