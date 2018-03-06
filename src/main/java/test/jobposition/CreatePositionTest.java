package test.jobposition;

import base.page.jobPosition.CreatePositionPage;
import base.page.jobPosition.PositionDetailPage;
import base.page.jobPosition.SearchPageInCreatePositionPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;

public class CreatePositionTest {
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
    public void createPositionTest(){
//        driver.get(GlobalVars.YC_POSITION_CREATE_URL);
//        CreatePositionPage cpp = PageFactory.initElements(driver,CreatePositionPage.class);
//        HashMap<String,String> result = cpp.createPosition();

        driver.get("http://test.hr.gxtr9.com/web/position.html#/position/details/5a97acdb52b1a248b28b0fd7ab2ad5e2");
        PositionDetailPage pdp = PageFactory.initElements(driver,PositionDetailPage.class);
        pdp.getDetail();

    }
    @AfterClass
    public void testDown(){
        //
    }
}
