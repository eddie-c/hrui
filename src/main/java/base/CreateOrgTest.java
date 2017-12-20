package base;

import base.pages.*;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgDetailPage;
import base.pages.ognization.OrgManagePage;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateOrgTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get(GlobalVars.YC_LOGIN_URL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(GlobalVars.YC_LOGIN_URL);
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.Login_Action(GlobalVars.LoginUsername,GlobalVars.LoginPassword);
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.gotoHrNavigation();
        homepage.gotoHrModule();
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
