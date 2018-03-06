package test.dataservice;

import base.pages.CommonPage;
import base.pages.dataservice.CreateOrderDinnerPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateOrderDinnerTest {
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
    public void testCreateOrderDinner(){
        CommonPage.gotoPage(driver,GlobalVars.YC_ORDER_FOOD_URL);
        CommonPage.gotoCreatePage(driver);
        CreateOrderDinnerPage codp = PageFactory.initElements(driver,CreateOrderDinnerPage.class);
        codp.createOrderDinner();
    }

}
