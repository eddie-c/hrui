package test.dataservice;

import base.page.jobPosition.JobMaintainPage;
import base.pages.CommonPage;
import base.pages.dataservice.OrderDinnerPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExportOrderDinnerTest {
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
        CommonPage.gotoPage(driver, GlobalVars.YC_ORDER_FOOD_URL);
        CommonPage.waitingForLoaing(driver);
        OrderDinnerPage opd = PageFactory.initElements(driver,OrderDinnerPage.class);
        opd.downloadAll();
    }

    @Test
    public void export02(){
        /*
         *   点击全选按钮，导出
         * */
        CommonPage.gotoPage(driver, GlobalVars.YC_ORDER_FOOD_URL);
        CommonPage.waitingForLoaing(driver);
        OrderDinnerPage opd = PageFactory.initElements(driver,OrderDinnerPage.class);
        opd.downloadOnePage();
    }
    @Test
    public void export03(){
        /*
         *   选择第一行，导出
         */
        CommonPage.gotoPage(driver, GlobalVars.YC_ORDER_FOOD_URL);
        CommonPage.waitingForLoaing(driver);
        OrderDinnerPage opd = PageFactory.initElements(driver,OrderDinnerPage.class);
        opd.downloadFirstRecord();
    }
}
