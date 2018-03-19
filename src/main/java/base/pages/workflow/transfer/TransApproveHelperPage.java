package base.pages.workflow.transfer;

import base.pages.CommonPage;
import common.SeleniumOp;
import common.Tools;
import common.common.utils.ReflectUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class TransApproveHelperPage {

    static WebDriver driver;

    @FindBy(how= How.XPATH,using="//div[contains(@autotest,\"approval_subject\")]//input")
    static List<WebElement> approveInputs;

    //是否需要划转客户的下拉框控件
    @FindBy(how=How.XPATH,using="//div[@autotest=\"approval_is_need_move_customers\"]")
    static WebElement needMoveCustomersDropdown;

    //是否需要划转客户的下拉框选项
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-select-dropdown__wrap\")]//li/span")
    static List<WebElement> needMoveCustomersItems;

    //费用是否清算划转下拉框控件
    @FindBy(how=How.XPATH,using="//div[@autotest=\"approval_is_move_fee\"]")
    static WebElement approvalIsMoveFeeDropdown;

    //费用是否清算划转下拉框选项
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-select-dropdown__wrap\")]//li/span")
    static List<WebElement> approvalIsMoveFeeItems;

    //资产是否完成复核下拉框控件
    @FindBy(how=How.XPATH,using="//div[@autotest=\"approval_is_move_fee_recheck\"]")
    static WebElement approvalIsMoveFeeRecheckDropdown;

    //资产是否完成复核下拉框选项
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-select-dropdown__wrap\")]//li/span")
    static List<WebElement> approvalIsMoveFeeRecheckItems;

    //定薪定级下拉框控件
    @FindBy(how=How.XPATH,using="//div[@autotest=\"approval_is_confirm_salary_level\"]")
    static WebElement approvalIsConfirmSalaryLevelDropdown;

    //定薪定级下拉框选项
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-select-dropdown__wrap\")]//li/span")
    static List<WebElement> approvalIsConfirmSalaryLevelItems;

    //调动状态确认下拉框控件
    @FindBy(how=How.XPATH,using="//div[@autotest=\"approval_move_status\"]")
    static WebElement approvalMoveStatusDropdown;

    //调动状态确认下拉框选项
    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-select-dropdown__wrap\")]//li/span")
    static List<WebElement> approvalMoveStatusItems;

    @FindBy(how=How.XPATH,using="//button/span[contains(text(),\"同意\")]")
    static WebElement acceptButton;

    @FindBy(how=How.XPATH,using="//button/span[contains(text(),\"退回\")]")
    static WebElement rejectButton;

    @FindBy(how=How.XPATH,using="//div[@class=\"el-message-box__btns\"]/button/span[contains(text(),\"确定\")]")
    static WebElement confirm;

    public TransApproveHelperPage(WebDriver driver){
        this.driver = driver;
    }

    public void scrollToEnd(){
        for(int i=0;i<5;i++){
            new WebDriverWait(driver,2).until(ExpectedConditions.visibilityOf(approveInputs.get(0)));
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("scroll(0,500);");
            if(approveInputs.get(0).isDisplayed()){
                break;
            }
        }
    }


    public void approveDeligate(WebElement dropdown,List<WebElement> options,List<WebElement> input){
        String approveStr = Tools.getRandomString(3);
        scrollToEnd();
        dropdown.click();
        new WebDriverWait(driver,5).until(ExpectedConditions.visibilityOfAllElements(options));
        options.get(0).click();
        input.get(0).sendKeys(approveStr);
        CommonPage.waitingForLoaing(driver);
        acceptButton.click();
        confirm.click();
    }

    public void approveDeligate(List<WebElement> input){
        String approveStr = Tools.getRandomString(3);
        scrollToEnd();
        input.get(0).sendKeys(approveStr);
        CommonPage.waitingForLoaing(driver);
        acceptButton.click();
        confirm.click();
    }

    /*
     *   Type1
     *   只有一个字段：审批意见
     *
     *   适合以下流程：
     *   调出部门运营经理、调出部门部总、判断条件：调出部门条线
     *
     * */
    public void approveType1(){
        approveDeligate(approveInputs);

    }



    /*
     *   Type2
     *   有两个字段：
     *   1. 审批意见
     *   2. 面试评估表上传
     * */
    public void approveType2(){
        approveDeligate(approveInputs);
    }

    /*
     *   Type3：是否
     *   有两个字段：
     *   1. 是否需要划转客户
     *   2. 审批意见
     * */
    public void approveType3(){
        approveDeligate(needMoveCustomersDropdown,needMoveCustomersItems,approveInputs);
    }

    /*
     *   Type4：调出部门所属条线、调出组织属性
     *   有两个字段：
     *   1. 是否完成划转客户
     *   2. 审批意见
     * */
    public void approveType4(){
        approveType1();
    }

    /*
     *   Type5：清点会费
     *   有两个字段：
     *   1. 流程说明 ：请及时清点工会费用，并将结果列示在审批意见中，以便财务部划转。
     *   2. 审批意见
     * */
    public void approveType5(){
        approveType1();
    }

    /*
     *   Type6：财务岗审批
     *   有两个字段：
     *   1. 费用是否清算划转
     *   2. 审批意见
     * */
    public void approveType6(){
        approveDeligate(approvalIsMoveFeeDropdown,approvalIsMoveFeeItems,approveInputs);
    }

    /*
     *   Type7：行政主管
     *   有两个字段：
     *   1. 费用是否完成复核
     *   2. 审批意见
     * */
    public void approveType7(){
        approveDeligate(approvalIsMoveFeeRecheckDropdown,approvalIsMoveFeeRecheckItems,approveInputs);
    }

    /*
     *   Type8：绩效岗审批
     *   有两个字段：
     *   1. 是否完成定薪定级
     *   2. 审批意见
     * */
    public void approveType8(){
        approveDeligate(approvalIsConfirmSalaryLevelDropdown,approvalIsConfirmSalaryLevelItems,approveInputs);
    }

    /*
     *   Type9：人事岗最终确认
     *   有两个字段：
     *   1. 调动状态确认
     *   2. 审批意见
     *   3. 勾选及备注
     * */
    public void approveType9(){
        approveDeligate(approvalMoveStatusDropdown,approvalMoveStatusItems,approveInputs);
    }

    public static void main(String[] args) {
        ReflectUtil.execute(new TransApproveHelperPage(driver),"approveType1");
    }

}
