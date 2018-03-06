package base.pages.dataservice;

import base.pages.CommonPage;
import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;

public class CreateOrderDinnerPage {

    WebDriver driver;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"商家区域\")]/following-sibling::div//input")
    WebElement shopDistrict;

    //页面里所有的列表框，此页面一共有三个，第一个是页面左侧导航栏，第二个是“商品类别”，第三个是
    //“商家区域”，可以根据“display：none”来判断当前激活的下拉框
    @FindBy(how=How.CLASS_NAME,using="el-select-dropdown")
    List<WebElement> pageDropdowns;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"商家名称\")]/following-sibling::div//input")
    WebElement shopName;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"商品名称\")]/following-sibling::div//input")
    WebElement goodName;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"商品类别\")]/following-sibling::div//input")
    WebElement goodType;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"商品单价\")]/following-sibling::div//input")
    WebElement price;

    @FindBy(how= How.XPATH,using="//label[contains(text(),\"计量单位\")]/following-sibling::div//input")
    WebElement unit;

    @FindBy(how=How.XPATH,using="//span[normalize-space(.)='保存']")
    WebElement saveBtn;

    @FindBy(how=How.XPATH,using="//span[contains(text(),\"确定\")]")
    WebElement confirmBtn;

    public CreateOrderDinnerPage(WebDriver driver){
        this.driver = driver;
    }

    public HashMap<String,String > createOrderDinner(){
        CommonPage.waitingForLoaing(driver);
        HashMap<String ,String> result = new HashMap<String, String>();
        CommonPage.waitingForLoaing(driver);
        //弹出窗口
        shopDistrict.click();
        WebElement districtDropdown;
        String districtTxt = "";
        String shopNameTxt = "AUTO_商家名称_"+ Tools.getRandomString(6);
        String goodNameTxt = "AUTO_商品名称_"+ Tools.getRandomString(6);

        String priceTxt = "35";
        String unitTxt = "份";
        //
        for (int i=0;i<pageDropdowns.size();i++){
            WebElement dropdown = pageDropdowns.get(i);
            if(dropdown.isDisplayed()){
                districtDropdown = dropdown;
                //取第一个选项就可以了
                WebElement firstdistrict = districtDropdown.findElements(By.className("el-select-dropdown__item")).get(0).findElement(By.tagName("span"));
                firstdistrict.click();
                districtTxt = firstdistrict.getText();
                break;
            }
        }

        shopName.sendKeys(shopNameTxt);
        goodName.sendKeys(goodNameTxt);
        price.sendKeys(priceTxt);
        unit.sendKeys(unitTxt);

        saveBtn.click();
        confirmBtn.click();

        result.put("shopName",shopNameTxt);
        result.put("goodName",goodNameTxt);
        result.put("price",priceTxt);
        result.put("shopDitrict",districtTxt);
        result.put("unit",unitTxt);
        return result;
    }

}
