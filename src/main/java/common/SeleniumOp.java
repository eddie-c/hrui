package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumOp {
    public static String getElementTextByElement(WebDriver driver, WebElement elem){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String result = (String) executor.executeScript("return arguments[0].innerText",elem);
        return result;
    }

    public static void clickElement(WebDriver driver, WebElement elem){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()",elem);
    }

    public static void clickBlank(WebDriver driver){
//        Actions actions = new Actions(driver);
//        actions.moveByOffset(0, 0).click().build().perform();
        driver.findElement(By.xpath("(//div[contains(@aria-label,\"Breadcrumb\")]//span[@class='el-breadcrumb__inner'])[last()]")).click();
    }

    public static String getElementTextByScript(WebDriver driver,String param){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        String result = (String) executor.executeScript(param);
        return result;
    }




}
