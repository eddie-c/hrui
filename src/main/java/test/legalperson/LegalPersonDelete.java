package test.legalperson;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.legalperson.CreateLegalPersonPage;
import base.pages.legalperson.LegalPersonDetailPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.ognization.OgnizationMainPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LegalPersonDelete {
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
    public void deleteLegalPersonTest(){
        OgnizationMainPage omp =  PageFactory.initElements(driver,OgnizationMainPage.class);
        omp.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver,LegalPersonMainPage.class);
        lpmp.gotoCreatePage();
        CreateLegalPersonPage clpp = PageFactory.initElements(driver,CreateLegalPersonPage.class);
        HashMap<String,String> result = clpp.createLegalPersonAndGotoListPage();
        String legalPersonName = result.get("yyzzLegalPersonNameTxt");
        lpmp.deleteLegalPersonByName(legalPersonName);
        lpmp.search(legalPersonName);
        Tools.sleep(1);
        Assert.assertEquals(lpmp.getSearchResultCount(),0);
    }
    public void tearDown(){
        //
    }
}
