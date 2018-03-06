package test.jobposition;

import base.page.jobPosition.CreatePositionPage;
import base.page.jobPosition.SearchPageInCreatePositionPage;
import base.pages.CommonPage;
import common.DriverAndDownloadPath;
import common.Driverop;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import test.CommonFuncs;

import java.util.HashMap;

public class SearchInCreatePositionTest {
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
    public void testSearchParentPosition(){
        driver.get(GlobalVars.YC_POSITION_CREATE_URL);
        CreatePositionPage cpp = PageFactory.initElements(driver,CreatePositionPage.class);

        cpp.popupParentPositionSearchDialog();
        SearchPageInCreatePositionPage spicpp = PageFactory.initElements(driver,SearchPageInCreatePositionPage.class);
        HashMap<String,String> result = spicpp.searchByCode("parentPosition","200001");
        // "code", "name", "level", "parentPosition","jobtype"
        Assert.assertEquals(result.get("code"),"200001");
        cpp.popupJobSearchDialog();

        //"code", "name", "jobtype", "level"
        result = spicpp.searchByCode("job","测试主管");
        Assert.assertEquals(result.get("jobtype"),"测试主管");
    }

}
