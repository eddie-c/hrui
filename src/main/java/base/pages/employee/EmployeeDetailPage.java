package base.pages.employee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class EmployeeDetailPage {
    final WebDriver driver;
    public EmployeeDetailPage(WebDriver driver){
        this.driver = driver;
    }

    @FindBy(how = How.XPATH, using = "//div[@class=\"info-title\"]")
    List<WebElement> modules;

    @FindBy(how = How.XPATH, using = "//div[@class=\"tag\"]")
    List<WebElement> fastLocationButtons;

    public void gotoModuleByName(String moduleName){
        WebElement target = null;
        for(int i=0;i<modules.size();i++){
            WebElement module =  modules.get(i);
            WebElement name = module.findElement(By.className("value"));
            String value = name.getText();
            if(name.getText().contains(moduleName)){
                target = modules.get(i);
                break;
            }
        }
        if( target != null){
            //首先点击页面右侧的快速定位按钮
            for(int i=0;i<fastLocationButtons.size();i++){
                if(fastLocationButtons.get(i).getText().contains(moduleName)){
                    fastLocationButtons.get(i).click();
                }
            }
            WebElement edit = target.findElement(By.className("el-icon-edit"));
            edit.click();
        }
    }
}
