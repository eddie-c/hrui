package test.dataservice;

import base.pages.CommonPage;
import base.pages.dataservice.CreateOrderDinnerPage;
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

public class DeleteDinnerTest {

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
    public void deleteTest(){
        CommonPage.gotoPage(driver, GlobalVars.YC_ORDER_FOOD_URL);
        CommonPage.gotoCreatePage(driver);
        CreateOrderDinnerPage codp = PageFactory.initElements(driver,CreateOrderDinnerPage.class);
        HashMap<String,String > result = codp.createOrderDinner();
        String name = result.get("goodName");
        OrderDinnerPage opd = PageFactory.initElements(driver,OrderDinnerPage.class);
        opd.search(name);
        HashMap<String,String> rowInfo = opd.getFirstRowInfo();
        Assert.assertEquals(rowInfo.get("goodName"),name);
        opd.deleteFirstRecord(driver);
    }

}
