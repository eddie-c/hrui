package base.pages.ognization;

import common.SeleniumOp;
import common.Tools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class CreateOrgPage {

    private final WebDriver driver;

    @FindBy(how= How.XPATH,using="//*[@for=\"name\"]/..//input")
    WebElement orgName;
    @FindBy(how= How.XPATH,using="//*[@for=\"shortname\"]/..//input")
    WebElement orgShortName;
    @FindBy(how= How.XPATH,using="//span[@class=\"el-cascader__label\"]")
    WebElement orgParentFrame;

//    @FindBy(how = How.XPATH,using="//li[@class=\"el-cascader-menu__item\" and contains(text(),\"国信证券泰九分公司\")]")
//    WebElement topLevelOrg;
    @FindBy(how = How.XPATH,using="//li[contains(text(),\"国信证券泰九分公司\")]")
    WebElement topLevelOrg;

    //所属条线
    @FindBy(how = How.XPATH,using="//label[@for='line']/following-sibling::div//input")
    WebElement line;

    @FindBy(how = How.XPATH, using = "(//ul[contains(@class,\"el-scrollbar__view\")])[last()]//span")
    List<WebElement> lineDropdownItems;

    @FindBy(how = How.XPATH,using="//li[contains(@class,\"el-cascader-menu__item\") and contains(text(),\"自动化专用\")]")
    WebElement orgAutoMenu;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"保存\")]")
    WebElement orgSaveButton;

    @FindBy(how = How.XPATH,using="//span[contains(text(),\"确定\")]")
    WebElement msgBoxConfirm;

    public CreateOrgPage(WebDriver driver){
        this.driver = driver;
    }

    public String createorg(){
        String orgNameText = "AUTO_组织_"+ Tools.getRandomString();
        orgName.sendKeys(orgNameText);
        orgParentFrame.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(topLevelOrg));
        topLevelOrg.click();

        new WebDriverWait(this.driver,30).until(
                ExpectedConditions.visibilityOf(orgAutoMenu));

        orgAutoMenu.click();

        SeleniumOp.clickBlank(driver);

        new WebDriverWait(this.driver,10).until(
                ExpectedConditions.elementToBeClickable(line)
        );


        line.click();
        SeleniumOp.clickElement(driver,lineDropdownItems.get(0));

        new WebDriverWait(this.driver,10).until(
                ExpectedConditions.elementToBeClickable(orgSaveButton)
        );


        orgSaveButton.click();
        msgBoxConfirm.click();
        return orgNameText;
    }



}
