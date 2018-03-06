package common;

import org.openqa.selenium.WebDriver;

public class DriverAndDownloadPath{
    public final WebDriver driver;
    public final String downloadpath;

    public DriverAndDownloadPath(WebDriver a, String b){
        driver = a;
        downloadpath = b;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public String getDownloadpath() {
        return downloadpath;
    }
}