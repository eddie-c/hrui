package test.legalperson;

import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.legalperson.CreateLegalPersonPage;
import base.pages.legalperson.LegalPersonDetailPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.ognization.OgnizationMainPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class EditLegalpersonTest {
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
        OgnizationMainPage ognizationMainPage = PageFactory.initElements(driver,OgnizationMainPage.class);
        //进入法人单位页面
        ognizationMainPage.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver, LegalPersonMainPage.class);
        //进入新建页面
        lpmp.gotoCreatePage();
        CreateLegalPersonPage clpp = PageFactory.initElements(driver,CreateLegalPersonPage.class);
        //新建法人单位，获取创建参数
        HashMap<String,String> createPageInfo = clpp.createLegalPersonAndGotoListPage();

        //回到法人单位界面
        ognizationMainPage.gotoLegalPersonPage();
        lpmp.search(createPageInfo.get("yyzzLegalPersonNameTxt"));
        lpmp.gotoEditPage();
        HashMap<String,String> editResult =  clpp.editLegalPerson();
        HashMap<String,String> result = lpmp.getDetailPageInfo(createPageInfo.get("yyzzLegalPersonNameTxt"));

        Assert.assertEquals(editResult.get("yyzzCreditCode"),result.get("yyzzCreditCodeTxt"));
        Assert.assertEquals(editResult.get("yyzzLegalPersonName"),result.get("yyzzLegalPersonName"));


    }
}
