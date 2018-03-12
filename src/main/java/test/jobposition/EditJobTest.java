package test.jobposition;

import base.page.jobPosition.CreateJobPage;
import base.page.jobPosition.JobMaintainPage;
import base.pages.CommonPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class EditJobTest {
    private WebDriver driver;
    private String downloadPath;
    @BeforeClass
    public void setUp(){
        DriverAndDownloadPath dadp = Driverop.getDriver();
        driver = dadp.getDriver();
        downloadPath = dadp.getDownloadpath();
        Driverop.commonSetup(driver);
    }

    @Test
    public void testEdit(){
        CommonPage.gotoPage(driver, GlobalVars.YC_JOB_MANAGE_URL);
        CommonPage.waitingForLoaing(driver);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);
        jmp.gotoCreatePage();
        CreateJobPage cjp = PageFactory.initElements(driver,CreateJobPage.class);
        HashMap<String,String> result = cjp.createJob();

        jmp.searchByJobName(result.get("name"));

        jmp.gotoEditPage();
        HashMap<String,String> editResult = cjp.editJob();

        HashMap<String,String> searchResult = jmp.getFirstRowInfo();
        Assert.assertEquals(searchResult.get("type"),editResult.get("type"));
        Assert.assertEquals(searchResult.get("level"),editResult.get("level"));
    }
}
