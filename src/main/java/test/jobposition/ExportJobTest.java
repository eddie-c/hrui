package test.jobposition;

import base.page.jobPosition.JobMaintainPage;
import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExportJobTest {
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
    public void export01(){
        /*
        *   不进行任何勾选，直接点击“导出”
        * */
        CommonPage.gotoPage(driver,GlobalVars.YC_JOB_MANAGE_URL);
        CommonPage.waitingForLoaing(driver);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);

        jmp.downloadAll();
    }

    @Test
    public void export02(){
        /*
         *   点击全选按钮，导出
         * */
        CommonPage.gotoPage(driver,GlobalVars.YC_JOB_MANAGE_URL);
        CommonPage.waitingForLoaing(driver);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);
        jmp.downloadOnePage();
    }
    @Test
    public void export03(){
        /*
         *   选择第一行，导出
         */
        CommonPage.gotoPage(driver,GlobalVars.YC_JOB_MANAGE_URL);
        CommonPage.waitingForLoaing(driver);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);
        jmp.downloadFirstRecord();
    }

}
