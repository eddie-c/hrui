package base.page.jobPosition;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class PositionDetailPage {

    @FindBy(how= How.XPATH,using="//div[contains(@aria-label,\"Breadcrumb\")]//span[@class='el-breadcrumb__inner']/span[last()]")
    WebElement navigateName;

    //职位编码
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职位编码\")]/following-sibling::div")
    WebElement positionCode;

    //职位名称
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职位名称\")]/following-sibling::div")
    WebElement positionName;

    //职等
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职等\")]/following-sibling::div")
    WebElement jobLevel;

    //上级职位
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"上级职位\")]/following-sibling::div")
    WebElement parrentPosition;

    //职务
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职务\")]/following-sibling::div")
    WebElement jobName;

    //职务类别
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职务类别\")]/following-sibling::div")
    WebElement jobType;

    //职级
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"职级\")]/following-sibling::div")
    WebElement positionLevel;

    //主要职责--职责描述
    @FindBy(how= How.XPATH,using="((//div[contains(@autotest,\"responsibility\")]//div[@class=\"table-tr\"])[2]//span)[1]")
    WebElement responsibilityDescription;
    //主要职责--衡量标准
    @FindBy(how= How.XPATH,using="((//div[contains(@autotest,\"responsibility\")]//div[@class=\"table-tr\"])[2]//span)[2]")
    WebElement metrics;

    //任职资格要求-教育背景
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"教育背景\")]/following-sibling::div/span")
    WebElement education;

    //任职资格要求-教育背景
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"工作经验\")]/following-sibling::div/span")
    WebElement experious;

    //任职资格要求-所需培训与资质
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"所需培训与资质\")]/following-sibling::div/span")
    WebElement train;

    //任职资格要求-基本技能
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"基本技能\")]/following-sibling::div/span")
    WebElement knowledge;

    //任职资格要求-专业技能
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"专业技能\")]/following-sibling::div/span")
    WebElement professinalKnowledge;

    //任职资格要求-综合技能
    @FindBy(how= How.XPATH,using="//div[contains(text(),\"综合技能\")]/../following-sibling::div/span")
    WebElement compKnowledge;

    // driver.find_element_by_xpath(u"//div[contains(text(),'综合技能')]/../following-sibling::div/span")



    @Test
    public void getDetail(){
        System.out.println(navigateName.getText());
        System.out.println(positionCode.getText());
        System.out.println(positionName.getText());
        System.out.println(jobLevel.getText());
        System.out.println(parrentPosition.getText());
        System.out.println(jobName.getText());
        System.out.println(jobType.getText());
        System.out.println(positionLevel.getText());
        System.out.println(responsibilityDescription.getText());
        System.out.println(metrics.getText());
        System.out.println(education.getText());
        System.out.println(experious.getText());
        System.out.println(train.getText());
        System.out.println(knowledge.getText());
        System.out.println(professinalKnowledge.getText());
        System.out.println(compKnowledge.getText());

    }

}
