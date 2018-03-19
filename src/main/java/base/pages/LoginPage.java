package base.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final WebDriver driver;
//    @FindBy(how= How.XPATH, using="//*[@class='bottom-group']/div[0]")
    @FindBy(how= How.XPATH, using="//*[@id=\"login\"]/div[1]/div[1]/div[2]/div[1]")
    public WebElement tab_userPass;

    @FindBy(how=How.XPATH,using="//*[@class='type1']//input[@type='text']")
    public WebElement txt_username;

    @FindBy(how=How.XPATH,using="//*[@class='type1']//input[@type='password']")
    public WebElement txt_password;

    @FindBy(how=How.CLASS_NAME,using="sumbit")
    public WebElement btn_Login;

    //如果登录成功以后，那么会有userName这个元素，这里用来判断是否登录成功，如果没有则重新登录
    @FindBy(how=How.CLASS_NAME,using="user")
    public WebElement userName;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean Login_Action(String sUserName,String sPassword){
        try {
            tab_userPass.click();
            txt_username.sendKeys(sUserName);
            txt_password.sendKeys(sPassword);
            btn_Login.click();
            userName.click();
            return true;
        }catch (Exception e){
            return false;
        }
    }
//    private static WebElement element = null;
//
//    public static WebElement userPassTab(WebDriver driver){
//        element = driver.findElement(By.className("bottom-group"))
//            .findElements(By.tagName("div")).get(0);
//        return element;
//    }
//
//    public static WebElement username(WebDriver driver){
//        element = driver.findElement(By.xpath("//*[@class='type1']//input[@type='text']"));
//        return element;
//    }
//
//    public static WebElement password(WebDriver driver){
//        element = driver.findElement(By.xpath("//*[@class='type1']//input[@type='password']"));
//        return element;
//    }
//
//    public static WebElement submit(WebDriver driver){
//        element = driver.findElement(By.className("sumbit"));
//        return element;
//    }
}
