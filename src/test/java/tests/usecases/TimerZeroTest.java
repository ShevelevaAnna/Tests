package tests.usecases;

import forms.AuthForm;
import forms.StartForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TimerZeroTest extends BaseTest {
    private final String TIME_ZERO = "00:00:00";

    /**
     * Тест-кейс 4
     * Перейти на  сайт по ссылке https://userinyerface.com/game.html%20target=	            Welcome page открыта
     * Проверить, что таймер начинает отсчет с нуля после открытия страницы                 Таймер начинает отсчет с нуля
     */
    @Test
    private void test(){
        StartForm startForm = new StartForm();
        Assert.assertTrue(startForm.isDisplayed(),"Start Form is not displayed");
        startForm.clickLinkNext();

        AuthForm authForm = new AuthForm();
        String textTimer = authForm.getTextTimer();
        Assert.assertEquals(textTimer, TIME_ZERO, "Timer is not null");
    }
}
