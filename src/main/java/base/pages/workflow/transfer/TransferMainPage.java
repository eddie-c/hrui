package base.pages.workflow.transfer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TransferMainPage {

    @FindBy(how= How.ID,using="tab-TransferApproving")
    WebElement transferApprovingTab;

    public void gotoApprovingPage(){
        transferApprovingTab.click();
    }
}
