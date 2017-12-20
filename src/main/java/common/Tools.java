package common;

import org.apache.commons.lang3.RandomStringUtils;

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
}
