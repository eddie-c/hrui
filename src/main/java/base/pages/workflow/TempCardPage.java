package base.pages.workflow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Arrays;
import java.util.List;

public class TempCardPage {

    List<String> tempCardType = Arrays.asList("新人入职申领","实习生临时申领","遗失补办临时申领");

    @FindBy(how= How.XPATH,using="//input[normalize-space(.)=\"请选择申请原因\"]")
    WebElement applyReasonDropDown;

    @FindBy(how=How.XPATH,using="//div[@class,\"el-select-dropdown__wrap\"]/li")
    List<WebElement> applyReasonItems;

    //实际使用人
    @FindBy(how=How.XPATH,using="//input[normalize-space(.)=\"请填写实际使用人\"]")
    WebElement lsgpsqUserName;
    //实际归还日期
    @FindBy(how=How.XPATH,using="//input[contains(@placeholder,\"选择日期\")]")
    WebElement lsgpsqReturnDate;


}
