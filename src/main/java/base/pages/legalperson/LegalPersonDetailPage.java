package base.pages.legalperson;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class LegalPersonDetailPage {
    //(//div[contains(@aria-label,"Breadcrumb")]//span[@class='el-breadcrumb__inner'])[last()]
    @FindBy(how = How.XPATH,using="(//div[contains(@aria-label,\"Breadcrumb\")]//span[@class='el-breadcrumb__inner'])[last()]")
    WebElement pageTitle;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"生效日期\")])[1]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement yyzzValidateTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"统一社会信用代码\")])[1]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement yyzzCreditCodeTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"法人名称\")])[1]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement yyzzLegalPersonName;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"生效日期\")])[2]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement jyxkzValidateTxt;

    @FindBy(how = How.XPATH,using="(//div[contains(text(),\"统一社会信用代码\")])[2]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement jyxkzCreditCodeTxt;

    @FindBy(how = How.XPATH,using="(//div[normalize-space(.)=\"法人名称\"])[2]/following-sibling::div[@class=\"m-section--cell-content\"]")
    WebElement jyxkzLegalPersonName;

    public HashMap<String,String> getElementsTxt(){
        HashMap<String,String> result = new HashMap<String, String>();
        result.put("pageTitle",pageTitle.getText());
        result.put("yyzzValidateTxt",yyzzValidateTxt.getText());
        result.put("yyzzCreditCodeTxt",yyzzCreditCodeTxt.getText());
        result.put("yyzzLegalPersonName",yyzzLegalPersonName.getText());
        result.put("jyxkzValidateTxt",jyxkzValidateTxt.getText());
        result.put("jyxkzCreditCodeTxt",jyxkzCreditCodeTxt.getText());
        //这句会报错！！！，只能先去掉了，找不到错误原因
        result.put("jyxkzLegalPersonName",jyxkzLegalPersonName.getText());
        return result;
    }
}
