package base;

import static org.testng.Assert.*;

import base.pages.HomePage;
import base.pages.LoginPage;
import comments.GlobalVars;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import sun.rmi.runtime.Log;

import java.util.concurrent.TimeUnit;

public class LoginYCTest {
    private WebDriver driver = null;
    HomePage homepage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(GlobalVars.YC_LOGIN_URL);
        loginpage = PageFactory.initElements(driver,LoginPage.class);
        homepage = PageFactory.initElements(driver,HomePage.class);
    }

    @Test
    public void testlogin(){
        loginpage.Login_Action("xn999","123123");
        assertEquals(homepage.getName(),"开发测试号");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
