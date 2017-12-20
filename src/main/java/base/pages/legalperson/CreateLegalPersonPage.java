package base.pages.legalperson;

import common.Tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CreateLegalPersonPage {
    //营业执照生效日期输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"yyzz_valid_date\"]/..//input")
    WebElement yyzzValidate;

    //统一社会信用码输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"yyzz_credit_code\"]/..//input")
    WebElement yyzzCreditCode;

    //营业执照法人名称输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"yyzz_legal_name\"]/..//input")
    WebElement yyzzLegalPersonName;

    //经营许可证生效日期输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"jyxkz_valid_date\"]/..//input")
    WebElement jyxkzValidate;

    //经营许可证统一社会信用码输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"jyxkz_credit_code\"]/..//input")
    WebElement jyxkzCreditCode;

    //经营许可证法人名称输入框
    @FindBy(how= How.XPATH,using="//*[@for=\"jyxkz_legal_name\"]/..//input")
    WebElement jyxkzLegalPersonName;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"保存\")]")
    WebElement saveButton;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    WebElement msgBoxConfirm;

    private final WebDriver driver;

    public CreateLegalPersonPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String> createLegalPerson(){
        /*
        *初始化输入内容
        * */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String validate = sdf.format(new Date());
        String creditcode = Tools.getRandomNumberString(20);
        String legalName = "AUTO_法人名称_"+Tools.getRandomString(10);
        /*
        *页面操作
        * */
        yyzzValidate.sendKeys(validate);
        jyxkzValidate.sendKeys(validate);
        yyzzCreditCode.sendKeys(creditcode);
        yyzzLegalPersonName.sendKeys(legalName);

//        Tools.sleep(1);

//        msgBoxConfirm.click();

        /*
        * Assert断言所需的信息
        * */
        HashMap<String,String> result = new HashMap<String,String>();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String yyzzValidateTxt = (String)jse.executeScript("return arguments[0].value",yyzzValidate);
        result.put("yyzzValidateTxt",yyzzValidateTxt);

        String yyzzCreditCodeTxt = (String)jse.executeScript("return arguments[0].value",yyzzCreditCode);
        result.put("yyzzCreditCodeTxt",yyzzCreditCodeTxt);

        String yyzzLegalPersonNameTxt = (String)jse.executeScript("return arguments[0].value",yyzzLegalPersonName);
        result.put("yyzzLegalPersonName",yyzzLegalPersonNameTxt);

        String jyxkzValidateTxt = (String)jse.executeScript("return arguments[0].value",jyxkzValidate);
        result.put("jyxkzValidateTxt",jyxkzValidateTxt);

        String jyxkzCreditCodeTxt = (String)jse.executeScript("return arguments[0].value",jyxkzCreditCode);
        result.put("jyxkzCreditCodeTxt",jyxkzCreditCodeTxt);

        String jyxkzLegalPersonNameTxt = (String)jse.executeScript("return arguments[0].value",jyxkzLegalPersonName);
        result.put("jyxkzLegalPersonNameTxt",jyxkzLegalPersonNameTxt);

        saveButton.click();
        return result;
    }

}
