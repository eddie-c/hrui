package base.pages.workflow.transfer;

import base.pages.CommonPage;
import common.common.utils.ReflectUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TranserApprovingPage {

    public WebDriver driver;

    @FindBy(how = How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]//td[contains(@class,\"autotest-actions\")]//button")
    private List<WebElement> resultApproveButtons;


    public TranserApprovingPage(WebDriver driver){
        this.driver = driver;
    }

    public void search(String text){
        CommonPage.search(driver,text);
    }

    public void gotoApprovePage(){
        CommonPage.waitingForLoaing(driver);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", resultApproveButtons.get(0));
    }

    public void approve(String type){
        TransApproveHelperPage tahp = PageFactory.initElements(driver,TransApproveHelperPage.class);
        ReflectUtil.execute(tahp,"approveType"+type);
    }

//    public void reject(String type){
//        TransApproveHelperPage.approveType1(false);
//    }

}
