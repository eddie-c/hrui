package test.dataservice;

import base.pages.CommonPage;
import base.pages.dataservice.OrderDinnerPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SearchOrderDinnerTest {
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
    public void testSearch01(){
        CommonPage.gotoPage(driver, GlobalVars.YC_ORDER_FOOD_URL);
        OrderDinnerPage opd = PageFactory.initElements(driver,OrderDinnerPage.class);
        opd.search("自动化专用商品");
        HashMap<String,String> result = opd.getFirstRowInfo();
        Assert.assertEquals(result.get("goodName"),"自动化专用商品");
    }
}
