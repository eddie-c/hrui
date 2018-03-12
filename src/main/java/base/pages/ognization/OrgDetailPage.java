package base.pages.ognization;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrgDetailPage {
    @FindBy(how = How.XPATH,using="(//div[contains(@aria-label,\"Breadcrumb\")]//span[@class='el-breadcrumb__inner'])[last()]")
    WebElement pageTitle;

    public String getTitle(){
        return pageTitle.getText();
    }
}
