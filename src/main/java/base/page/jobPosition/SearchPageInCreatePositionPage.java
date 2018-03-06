package base.page.jobPosition;

import common.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SearchPageInCreatePositionPage {

    WebElement parentPositionSearchDialog = null;
    WebElement jobSearchDialog = null;
    WebElement currentDialog = null;
    WebElement currentSearchInput = null;
    WebElement currentSearchButton = null;
    String currentType;

    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-dialog__wrapper\")]")
//    @FindBy(how=How.CLASS_NAME,using="el-dialog__wrapper")
    List<WebElement> searchDialogs;

    @FindBy(how=How.XPATH,using="//span[contains(@text,\"确定\")]")
    WebElement confirm;

    @FindBy(how=How.XPATH,using="//div[contains(@class,\"el-table__body-wrapper\")]//tr")
    private List<WebElement> searchResults;

    public void getSearchElements(String type){
        WebElement dialog = null;
        getDialogs();

        if(type.equals("job")){
            dialog = jobSearchDialog;
        }
        if(type.equals("parentPosition")){
            dialog = parentPositionSearchDialog;
        }
        currentDialog = dialog;
        currentSearchInput = dialog.findElement(By.className("search")).findElement(By.tagName("input"));
        currentSearchButton = dialog.findElement(By.className("search")).findElement(By.tagName("button"));
    }

    public WebElement getCurrentSearchInput(String type) {
        getSearchElements(type);
        return currentSearchInput;
    }


    public void getDialogs(){
        for(int i=0;i<searchDialogs.size();i++){
            WebElement dialog = searchDialogs.get(i);

            if(dialog.findElement(By.className("el-dialog__title")).getText().contains("请选择上级职位")){
                parentPositionSearchDialog = dialog;
            }else if(dialog.findElement(By.className("el-dialog__title")).getText().contains("请选择职务")){
                jobSearchDialog = dialog;
            }
        }
    }

    public HashMap<String,String> getFirstRowInfo(String type){
        WebElement firstrow = searchResults.get(0);
//        firstrow.findElement()
        HashMap<String,String> result = new HashMap<String, String>();
        List<String> rowinfoParams;
        if(type.equals("parentPosition")) {
            rowinfoParams = Arrays.asList(
                    "code", "name", "level", "parentPosition", "jobtype"
            );
        }else{
            rowinfoParams = Arrays.asList(
                    "code", "name", "jobtype", "level"
            );
        }
        for(int i=0;i<rowinfoParams.size();i++){
            String param = rowinfoParams.get(i);
            result.put(param,
                    firstrow.findElements(By.className("cell")).get(i).getText());
        }
        return result;
    }

    public void clickFirstRow(){
        List<WebElement> rows = currentDialog.findElements(By.className("el-table__row"));
        WebElement row = rows.get(0);
        List<WebElement> columns = row.findElements(By.tagName("td"));
        columns.get(0).click();
//        点击确认按键
//        currentDialog.findElement(By.className("m-dialog-select__btn")).
//                findElements(By.tagName("span")).get(0).click();
    }

    public HashMap<String,String> searchByCode(String type,String code){
        currentType = type;
        WebElement searchInputElement = getCurrentSearchInput(type);
        searchInputElement.sendKeys(code);
        currentSearchButton.click();
        clickFirstRow();
        HashMap<String,String> result =  getFirstRowInfo(type);
        Tools.sleep(1);
//        confirm.click();
        currentDialog.findElement(By.className("m-dialog-select__btn")).
                findElements(By.tagName("span")).get(0).click();
        return result;
    }

}
