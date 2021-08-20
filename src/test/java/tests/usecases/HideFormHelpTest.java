package tests.usecases;

import forms.HelpForm;
import forms.StartForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HideFormHelpTest extends BaseTest {
    /**
     * Тест-кейс 2
     * Перейти на  сайт по ссылке https://userinyerface.com/game.html%20target=	            Welcome page открыта
     * Скрыть окно форму "Help"	                                                            Форма скрыта
     */
    @Test
    private void test(){
        StartForm startForm = new StartForm();
        Assert.assertTrue(startForm.isDisplayed(),"Start Form is not displayed");
        startForm.clickLinkNext();

        HelpForm helpForm = new HelpForm();
        helpForm.clickSendBtn();
        Assert.assertTrue(helpForm.isHidden(),"Help Form is displayed");
    }
}
