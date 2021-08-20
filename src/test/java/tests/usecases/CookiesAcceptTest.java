package tests.usecases;

import forms.CookiesForm;
import forms.StartForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class CookiesAcceptTest extends BaseTest {
    /**
     * Тест-кейс 3
     * Перейти на  сайт по ссылке https://userinyerface.com/game.html%20target=	            Welcome page открыта
     * Принять использование                                                                cookie	Форма скрыта
     */
    @Test
    private void test(){
        StartForm startForm = new StartForm();
        Assert.assertTrue(startForm.isDisplayed(),"Start Form is not displayed");
        startForm.clickLinkNext();

        CookiesForm cookiesForm = new CookiesForm();
        cookiesForm.clickCookiesYesButton();
        Assert.assertTrue(cookiesForm.cookiesIsNotDisplayed(),"Cookies Form is displayed");
    }
}
