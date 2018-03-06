package base.pages.workflow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class WorkflowNavigatePage {
    //人事证明
    @FindBy(how= How.CLASS_NAME,using="personal-cert")
    WebElement approveEntry;

    //临时卡申请
    @FindBy(how= How.CLASS_NAME,using="temp-card")
    WebElement tempCardEntry;

    //正式工卡申请
    @FindBy(how= How.CLASS_NAME,using="official-card")
    WebElement officialCardEntry;

    //订餐服务
    @FindBy(how= How.CLASS_NAME,using="order-food")
    WebElement orderFoodEntry;

    //宣传品印刷制作
    @FindBy(how= How.CLASS_NAME,using="material-printing")
    WebElement materialPrintingEntry;

    //高速行情采购
    @FindBy(how= How.CLASS_NAME,using="high-speed-market")
    WebElement highSpeedMarketEntry;

    //行政运营支持办公费申请
    @FindBy(how= How.CLASS_NAME,using="hao-express")
    WebElement aoExpressEntry;

    //名片制作
    @FindBy(how= How.CLASS_NAME,using="business-card")
    WebElement businessCardEntry;

    //固定资产申请
    @FindBy(how= How.CLASS_NAME,using="fixed-assets")
    WebElement fixedAssetsEntry;

    //车辆服务
    @FindBy(how= How.CLASS_NAME,using="car")
    WebElement carEntry;

    //IT服务
    @FindBy(how= How.CLASS_NAME,using="it")
    WebElement itEntry;

    //物料超市
    @FindBy(how= How.CLASS_NAME,using="goods")
    WebElement goodsEntry;
}
