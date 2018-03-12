package test.org;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgMergePage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrgMergeTest {
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
    public void testMerge(){
        //进入新建页面创建一个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);

        CreateOrgPage orgCreatePage = PageFactory.initElements(driver,CreateOrgPage.class);
        String orgNameMergeFrom = orgCreatePage.createorg();
        Tools.sleep(1);
        //创建第二个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);
        String orgNameMergeTo = orgCreatePage.createorg();
        Tools.sleep(1);
        //进入合并页面，合并上面创建的组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_MERGE_URL);
        OrgMergePage om = PageFactory.initElements(driver,OrgMergePage.class);
        om.merge(orgNameMergeFrom,orgNameMergeTo);
    }

    @AfterMethod
    public void tearDown(){

    }
}
