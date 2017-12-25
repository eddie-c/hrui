package common;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;
import java.io.IOException;

public class Tools {

    public static String getRandomString(int len){
        return RandomStringUtils.random(len,true,true);
    }
    public static String getRandomString(){
        return Tools.getRandomString(6);
    }
    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String getRandomNumberString(int len){
        return RandomStringUtils.random(len,false,true);
    }
    public static String getRandomNumberString(){
        return Tools.getRandomNumberString(6);
    }

    public static String mkTmpDirWindows(){
        String tmpdir = "d:\\"+getRandomString();
        String[] cmd = {"cmd","/C","mkdir"+tmpdir};
        try {
            Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        System.out.println(tmpdir);
        return tmpdir;
        //        File tmpdir = new File("d:/"+getRandomString());
//        boolean bool =  tmpdir.mkdir();
//        if(bool){
//            return tmpdir.getPath();
//        }else {
//            return "";
//        }
    }



    public static String mkTmpDirLinux(){
        return "";
    }

    public static Boolean rmTmpDirWindows(String tmpdir){
        try {
            Runtime.getRuntime().exec("rd /s /q "+tmpdir);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

