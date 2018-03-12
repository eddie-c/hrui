package test.org;

import base.pages.*;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgDetailPage;
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

public class CreateOrgTest {
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
    public void testCreate(){
        driver.get(GlobalVars.YC_HR_ORG_MANAGE_PAGE_URL);
        OrgManagePage orgManagePage = PageFactory.initElements(driver,OrgManagePage.class);
        orgManagePage.gotoCreatePage();
        CreateOrgPage orgCreatePage = PageFactory.initElements(driver,CreateOrgPage.class);
        String newOrgName = orgCreatePage.createorg();
        OrgDetailPage orgDetailPage = PageFactory.initElements(driver,OrgDetailPage.class);
//        Assert.assertEquals(newOrgName,orgDetailPage.getTitle());
        System.out.println(orgDetailPage.getTitle());
        Assert.assertTrue(orgDetailPage.getTitle().contains(newOrgName));
//        orgCreatePage.createorg();
    }

    @AfterMethod
    public void tearDown(){

    }
}
