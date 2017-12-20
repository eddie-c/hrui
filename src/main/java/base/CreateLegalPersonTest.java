package base;

import base.pages.legalperson.CreateLegalPersonPage;
import base.pages.HomePage;
import base.pages.legalperson.LegalPersonDetailPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.LoginPage;
import base.pages.ognization.OgnizationMainPage;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateLegalPersonTest {
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
    public void testCreateLegalPerson(){
        OgnizationMainPage ognizationMainPage = PageFactory.initElements(driver,OgnizationMainPage.class);
        //进入法人单位页面
        ognizationMainPage.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver, LegalPersonMainPage.class);
        //进入新建页面
        lpmp.gotoCreatePage();
        CreateLegalPersonPage clpp = PageFactory.initElements(driver,CreateLegalPersonPage.class);
//        HashMap<String,String> createPageInfo = new HashMap<String, String>();
//        HashMap<String,String> detailPageInfo = new HashMap<String, String>();
        //新建法人单位，获取创建参数
        HashMap<String,String> createPageInfo = clpp.createLegalPerson();
        LegalPersonDetailPage lpdp = PageFactory.initElements(driver,LegalPersonDetailPage.class);
        //获取详情页面参数
        HashMap<String,String> detailPageInfo = lpdp.getElementsTxt();
        /*
        * 一系列比较
        * */
        Assert.assertEquals(createPageInfo.get("yyzzValidateTxt"),detailPageInfo.get("yyzzValidateTxt"));
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
    }
}
