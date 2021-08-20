package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;

public class BrowserUtils {
    private static Browser getBrowser() {
        return AqualityServices.getBrowser();
    }

    public static void browserGoTo(String path){
        getBrowser().goTo(path);
    }

    public static void browserMaximize(){
        getBrowser().maximize();
    }

    public static boolean isBrowserStated(){
        return AqualityServices.isBrowserStarted();
    }
    public static void browserQuit(){
        AqualityServices.getBrowser().quit();
    }
}
