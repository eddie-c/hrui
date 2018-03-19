package test.workflow.trans;

import base.pages.workflow.ApproveNode;
import base.pages.workflow.transfer.TranserApprovingPage;
import base.pages.workflow.transfer.TransferMainPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import common.common.utils.WorkflowFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TransApproveTest {

    private WebDriver driver;
    private String downloadPath;
    @BeforeClass
    public void setUp(){

    }

    @Test
    public void testApprove(){
        List<ApproveNode> nodelist = WorkflowFiles.getTransConfig();
        for(int i=0;i<nodelist.size();i++){
            ApproveNode node = nodelist.get(i);
            String uid = node.getUid();
            String type = node.getType();

            DriverAndDownloadPath dadp = Driverop.getDriver();
            driver = dadp.getDriver();
            downloadPath = dadp.getDownloadpath();

            Driverop.approveSetup(driver,uid,"123123");

            driver.get(GlobalVars.YC_WORKFLOW_TRANSFER_MAIN_URL);
            TransferMainPage tmp = PageFactory.initElements(driver,TransferMainPage.class);
            tmp.gotoApprovingPage();
            TranserApprovingPage tap = PageFactory.initElements(driver, TranserApprovingPage.class);
//            tap.search("81161");
            tap.search("DD180316003");
            tap.gotoApprovePage();
            tap.approve(type);
            if(node.isLastNode()){
                break;
            }else{
//                driver.quit();
            }

        }


    }

}
