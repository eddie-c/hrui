package test.jobposition;

import base.page.jobPosition.CreateJobPage;
import base.page.jobPosition.JobMaintainPage;
import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import base.pages.employee.EmpMaintainPage;
import base.pages.employee.EmployeeDetailPage;
import common.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateJobTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
    public void createJobTest(){
        CommonPage.gotoPage(driver,GlobalVars.YC_JOB_MANAGE_URL);
        CommonPage.waitingForLoaing(driver);
        JobMaintainPage jmp = PageFactory.initElements(driver,JobMaintainPage.class);
        jmp.gotoCreatePage();
        CreateJobPage cjp = PageFactory.initElements(driver,CreateJobPage.class);
        HashMap<String,String> result = cjp.createJob();

        jmp.searchByJobName(result.get("name"));
        HashMap<String,String>detailPageResult = jmp.getFirstRowInfo();

        //比较新建时的参数和搜索后的参数，是否一样
        for(String key : result.keySet())
            for(int i=0;i<result.size();i++){
                Assert.assertEquals(result.get(key),detailPageResult.get(key));
            }

    }

}
