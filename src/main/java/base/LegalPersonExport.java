package base;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.legalperson.LegalPersonMainPage;
import base.pages.ognization.OgnizationMainPage;
import common.GlobalVars;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LegalPersonExport {
    private WebDriver driver;
    private String tmpdir;
    @BeforeClass
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        tmpdir = Tools.mkTmpDirWindows();
        HashMap<String,Object> chromeprefs = new HashMap<String, Object>();
        chromeprefs.put("profile.default_content_settings.popups", 0);
        chromeprefs.put("download.default_directory", tmpdir);
        options.setExperimentalOption("prefs",chromeprefs);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(GlobalVars.YC_LOGIN_URL);
        LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
        loginPage.Login_Action(GlobalVars.LoginUsername,GlobalVars.LoginPassword);
        HomePage homepage = PageFactory.initElements(driver, HomePage.class);
        homepage.gotoHrNavigation();
        homepage.gotoHrModule();
        PageFactory.initElements(driver,CommonPage.class);
    }
   /*
   * 导出两个文件，全选一页，和不勾选直接点击导出
   * 检查点为：文件路径下，是否有两个文件
   * */
    @Test
    public void testlegalPersonExport(){
        OgnizationMainPage ognizationMainPage = PageFactory.initElements(driver,OgnizationMainPage.class);
        //进入法人单位页面
        ognizationMainPage.gotoLegalPersonPage();
        LegalPersonMainPage lpmp = PageFactory.initElements(driver, LegalPersonMainPage.class);
        lpmp.downloadAll();
        lpmp.downloadOnePage();
        File file = new File(tmpdir);
        File[] filelist = file.listFiles();
        Assert.assertEquals(filelist.length,2);
    }

    @AfterClass
    public void tearDown(){
        Tools.rmTmpDirWindows(tmpdir);
//        driver.quit();
    }

}
