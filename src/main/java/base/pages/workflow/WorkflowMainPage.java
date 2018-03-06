package base.pages.workflow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WorkflowMainPage {
    //页面顶部tab

    //流程发起
    @FindBy(how= How.ID,using="tab-pa")
    WebElement paTab;
    //待我审批
    @FindBy(how= How.ID,using="tab-approving")
    WebElement approvingTab;
    //我已审批
    @FindBy(how=How.ID,using="tab-approved")
    WebElement approvedTab;
    //我发起的
    @FindBy(how=How.ID,using="tab-application")
    WebElement applicationTab;

    
}
