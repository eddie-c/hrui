package base.pages.ognization;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class OrgImportPage {
    @FindBy(how= How.XPATH,using = "//span[contains(text(),\"下载模板\")]")
    WebElement downloadTemplateButton;

    @FindBy(how=How.XPATH,using="//input[@type=\"file\"]")
    WebElement chooseFile;

    @FindBy(how=How.XPATH,using="//span[contains(text(),\"开始上传\")]")
    WebElement uploadButton;

    public void uploadfile(String filename){
        chooseFile.sendKeys("C:\\Users\\tj\\Downloads\\组织信息导入模板.xlsx");
        uploadButton.click();
    }
}
