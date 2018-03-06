package test.legalperson;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.ognization.OgnizationMainPage;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LegalPersonSearch {
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
        PageFactory.initElements(driver, CommonPage.class);
    }

    /*
    * 搜索：全字匹配，只搜索出一个结果
    * */
    @Test
    public void testSearch01(){
        OgnizationMainPage ognizationMainPage = PageFactory.initElements(driver,OgnizationMainPage.class);
        //进入法人单位页面
        ognizationMainPage.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver, LegalPersonMainPage.class);
        lpmp.search(" SEARCH专用01");
        Assert.assertEquals(lpmp.getSearchResultCount(),1);
    }

    /*
     * 搜索：部分匹配，搜索出两个结果
     * */
    @Test
    public void testSearch02(){
        OgnizationMainPage ognizationMainPage = PageFactory.initElements(driver,OgnizationMainPage.class);
        //进入法人单位页面
        ognizationMainPage.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver, LegalPersonMainPage.class);
        lpmp.search(" SEARCH专用");
        Assert.assertEquals(lpmp.getSearchResultCount(),2);
    }


    public void tearDown(){
//        driver.quit();
    }
}
