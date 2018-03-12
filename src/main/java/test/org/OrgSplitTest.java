package test.org;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgMergePage;
import base.pages.ognization.OrgSplitPage;
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

public class OrgSplitTest {
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
    public void testSplit(){
        //进入新建页面创建一个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);
        CreateOrgPage orgCreatePage = PageFactory.initElements(driver,CreateOrgPage.class);
        String orgNameSplitFrom = orgCreatePage.createorg();
        Tools.sleep(1);
        //创建第二个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);
        String orgNameSplitTo = orgCreatePage.createorg();
        Tools.sleep(1);
        //进入拆分页面，拆分上面创建的组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_SPLIT_URL);
        OrgSplitPage osp = PageFactory.initElements(driver,OrgSplitPage.class);
        osp.split(orgNameSplitFrom,orgNameSplitTo);
    }

    @AfterMethod
    public void tearDown(){

    }
}
