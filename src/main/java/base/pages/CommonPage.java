package base.pages;

import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.management.monitor.CounterMonitor;

/*
* 对某些特别的控件，模拟出的页面
* */
public class CommonPage {
    //页面标题
    @FindBy(how = How.CLASS_NAME,using="page--title")
    WebElement pageTitle;

    //页面加载元素
    @FindBy(how= How.CLASS_NAME,using="el-loading-mask")
    private static WebElement loaingMask;

    public static void waitingForLoaing(WebDriver driver){
        if (loaingMask != null){
            new WebDriverWait(driver, 30).until(
                    ExpectedConditions.invisibilityOf(loaingMask));
        }
    }

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    private static WebElement msgBoxConfirm;

    public static void gotoPage(WebDriver driver,String pageurl){
        driver.get(pageurl);
        waitingForLoaing(driver);
    }

    public static void confirm(){
        msgBoxConfirm.click();
    }
}
