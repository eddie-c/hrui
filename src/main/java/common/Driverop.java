package common;

import base.pages.CommonPage;
import base.pages.HomePage;
import base.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Driverop {
    public static DriverAndDownloadPath getDriver(){
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        String tmpdir = Tools.mkTmpDirWindows();
        HashMap<String,Object> chromeprefs = new HashMap<String, Object>();
        chromeprefs.put("profile.default_content_settings.popups", 0);
        chromeprefs.put("download.default_directory", tmpdir);
        options.setExperimentalOption("prefs",chromeprefs);
        driver = new ChromeDriver(options);
        DriverAndDownloadPath dadp = new DriverAndDownloadPath(driver,tmpdir);
        return dadp;
//        return driver;
    }

    public static void commonSetup(WebDriver driver){
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


}

