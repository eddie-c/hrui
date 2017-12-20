package base.pages.legalperson;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class LegalPersonDetailPage {
    @FindBy(how = How.CLASS_NAME,using="page--title")
    WebElement pageTitle;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"生效日期\")])[1]/following-sibling::div[@class=\"text\"]")
    WebElement yyzzValidateTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"统一社会信用代码\")])[1]/following-sibling::div[@class=\"text\"]")
    WebElement yyzzCreditCodeTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"法人名称\")])[1]/following-sibling::div[@class=\"text\"]")
    WebElement yyzzLegalPersonName;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"生效日期\")])[2]/following-sibling::div[@class=\"text\"]")
    WebElement jyxkzValidateTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"统一社会信用代码\")])[2]/following-sibling::div[@class=\"text\"]")
    WebElement jyxkzCreditCodeTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"法人名称\")])[2]/following-sibling::div[@class=\"text\"]")
    WebElement jyxkzLegalPersonName;

    public HashMap<String,String> getElementsTxt(){
        HashMap<String,String> result = new HashMap<String, String>();
        result.put("pageTitle",pageTitle.getText());
        result.put("yyzzValidateTxt",yyzzValidateTxt.getText());
        result.put("yyzzCreditCodeTxt",yyzzCreditCodeTxt.getText());
        result.put("yyzzLegalPersonName",yyzzLegalPersonName.getText());
        result.put("jyxkzValidateTxt",jyxkzValidateTxt.getText());
        result.put("jyxkzCreditCodeTxt",jyxkzCreditCodeTxt.getText());
        result.put("jyxkzLegalPersonName",jyxkzLegalPersonName.getText());
        return result;
    }
}
