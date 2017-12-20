package base;

import base.pages.HomePage;
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

import java.util.concurrent.TimeUnit;

public class HrEntryTest {
    WebDriver driver = null;
    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(GlobalVars.YC_LOGIN_URL);
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.Login_Action(GlobalVars.LoginUsername,GlobalVars.LoginPassword);
    }

    @Test
    public void getintoHrPage(){
        HomePage homepage = PageFactory.initElements(this.driver,HomePage.class);
        homepage.gotoHrNavigation();
        homepage.gotoHrModule();
        OgnizationMainPage ogpage = PageFactory.initElements(this.driver,OgnizationMainPage.class);
        Assert.assertEquals(ogpage.getPageTitle(),"组织管理");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}


