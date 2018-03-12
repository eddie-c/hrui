package test.org;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgDetailPage;
import base.pages.ognization.OrgImportPage;
import base.pages.ognization.OrgManagePage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImportOrgTest {
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
    public void testImport(){
        driver.get(GlobalVars.YC_HR_ORG_MANAGE_PAGE_URL);
        OrgManagePage orgManagePage = PageFactory.initElements(driver,OrgManagePage.class);
        orgManagePage.gotoImportPage();
        OrgImportPage oip = PageFactory.initElements(driver, OrgImportPage.class);
        oip.uploadfile("test");
    }

    @AfterMethod
    public void tearDown(){

    }
}
