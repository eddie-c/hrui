package test.legalperson;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.legalperson.CreateLegalPersonPage;
import base.pages.legalperson.LegalPersonDetailPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.ognization.OgnizationMainPage;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LegalPersonDelete {
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

    @Test
    public void deleteLegalPersonTest(){
        OgnizationMainPage omp =  PageFactory.initElements(driver,OgnizationMainPage.class);
        omp.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver,LegalPersonMainPage.class);
        lpmp.gotoCreatePage();
        CreateLegalPersonPage clpp = PageFactory.initElements(driver,CreateLegalPersonPage.class);
        HashMap<String,String> result = clpp.createLegalPerson();
        String legalPersonName = result.get("yyzzLegalPersonName");
        lpmp.deleteLegalPersonByName(legalPersonName);
        lpmp.search(legalPersonName);
        Tools.sleep(1);
        Assert.assertEquals(lpmp.getSearchResultCount(),0);
    }
    public void tearDown(){
        //
    }
}
