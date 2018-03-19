package common.common.utils;

import base.pages.workflow.ApproveNode;
import files.GetFilsPath;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class WorkflowFiles {
    public static List<ApproveNode> getTransConfig(){
        FileUtils fu = new FileUtils();
        List<ApproveNode> nodelist = new ArrayList<ApproveNode>();
        try {
            List<String> lines = IOUtils.readLines(new FileInputStream(new GetFilsPath().getPath()+"trans01.txt"));
            for(String line:lines){
                String[] t = line.split(" ");
//                System.out.println(t.length);
                ApproveNode tmp = new ApproveNode(t[0],t[1],t[2],t[3].equals("1"));
                nodelist.add(tmp);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return nodelist;
    }

    public static void main(String[] args) {
        WorkflowFiles.getTransConfig();
    }
}
