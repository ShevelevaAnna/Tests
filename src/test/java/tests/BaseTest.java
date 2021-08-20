package tests;

import utils.BrowserUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    @BeforeMethod
    protected void beforeMethod() {
        BrowserUtils.browserGoTo("https://userinyerface.com/game.html%20target=");
        BrowserUtils.browserMaximize();
    }

    @AfterMethod
    public void afterTest() {
        if (BrowserUtils.isBrowserStated()) {
            BrowserUtils.browserQuit();
        }
    }
}
