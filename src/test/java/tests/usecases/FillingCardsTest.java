package tests.usecases;

import forms.AuthForm;
import forms.AvatarAndInterestsForm;
import forms.PersonalDetailsForm;
import forms.StartForm;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.ParametersForTest;

import java.util.ArrayList;

public class FillingCardsTest extends BaseTest {
    private final int INTEREST_UNSELECT_ALL = 21;

    /**
     * Тест-кейс 1
     * Перейти на сайт по ссылке https://userinyerface.com/game.html%20target=	            Welcome page открыта
     * Перейти по ссылке к следующей странице (Please click HERE to GO to the next page)	Открыта 1 карточка для заполнения информации
     * Ввести случайный корректный пароль, email, принять условия использования,            Открыта 2 карточка для заполнения информации
     * нажать кнопку Next
     * Выбрать 3 случайных интереса, загрузить любое изображение, нажать кнопку Next	    Открыта 3 карточка для заполнения информации
     * @param password
     * @param email
     * @param domain_item
     * @param domain
     * @param interests
     */
    @Test(dataProvider = "Auth", dataProviderClass = ParametersForTest.class)
    private void test(String password, String email, int domain_item, String domain, ArrayList<Integer> interests, String fullPathImg){
        StartForm startForm = new StartForm();
        Assert.assertTrue(startForm.isDisplayed(),"Start Form is not displayed");
        startForm.clickLinkNext();

        AuthForm authForm = new AuthForm();
        Assert.assertTrue(authForm.isDisplayed(),"Auth Form is not displayed");

        authForm.inputData(password, email, domain);
        authForm.clickDomain(domain_item);
        authForm.uncheckCheckBox();
        authForm.clickNext();

        AvatarAndInterestsForm avtrAndIntrForm = new AvatarAndInterestsForm();
        Assert.assertTrue(avtrAndIntrForm.isDisplayed(),"Avatar and Interests Form is not displayed");

        avtrAndIntrForm.clickUploadBtn();
        avtrAndIntrForm.uploadIMG(fullPathImg);
        avtrAndIntrForm.clickInterestCheckBox(INTEREST_UNSELECT_ALL);
        avtrAndIntrForm.clickInterestCheckBox(interests.get(0));
        avtrAndIntrForm.clickInterestCheckBox(interests.get(1));
        avtrAndIntrForm.clickInterestCheckBox(interests.get(2));
        avtrAndIntrForm.clickNextButton();

        PersonalDetailsForm personalDtlsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDtlsForm.isDisplayed(),"Personal Details Form is not displayed");
    }
}
