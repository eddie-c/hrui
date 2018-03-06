package test.org;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.ognization.CreateOrgPage;
import base.pages.ognization.OrgChangeHigherPage;
import base.pages.ognization.OrgSplitPage;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OrgChangeHigherTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    public void testChangeHigher(){
        //进入新建页面创建一个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);
        CreateOrgPage orgCreatePage = PageFactory.initElements(driver,CreateOrgPage.class);
        String orgNameSplitFrom = orgCreatePage.createorg();
        Tools.sleep(1);
        //创建第二个组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CREATE_URL);
        String orgNameSplitTo = orgCreatePage.createorg();
        Tools.sleep(1);
        //进入上级组织调整页面，调整上面创建的组织
        CommonPage.gotoPage(driver,GlobalVars.YC_ORG_CHANGE_HIGHER_URL);
        OrgChangeHigherPage ochp = PageFactory.initElements(driver,OrgChangeHigherPage.class);
        ochp.adjust(orgNameSplitFrom,orgNameSplitTo);
    }

    @AfterMethod
    public void tearDown(){

    }
}
