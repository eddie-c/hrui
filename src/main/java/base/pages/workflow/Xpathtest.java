package base.pages.workflow;

import com.alics.core.util.IOUtil;
import com.alics.core.xml.XPathBaseXMLParser;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class Xpathtest {
    public static void main(String[] args) throws Exception{
        String content = IOUtil.getContentFromFile("E:\\projects\\java\\hrui\\src\\main\\java\\base\\pages\\workflow\\workflow.xml","utf8");
        String ret = XPathBaseXMLParser.getNodeStrByExp("(//workflows/tmpcard/applysheet/reason)[1]/text()", content, null);
        System.out.println(ret);
    }
}
