package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private final IButton btnCookiesYes = getElementFactory().getButton(By.xpath("//*[contains(@class,\"transparent\")]"), "Cookies Yes Button");
    private final ILabel lblUnloadCookies = getElementFactory().getLabel(By.className("cookies"), "Uniq Element Cookies Form");

    public CookiesForm() {
        super(By.className("cookies"),"Cookies Form");
    }

    public boolean cookiesIsNotDisplayed(){
        return lblUnloadCookies.state().waitForNotDisplayed();
    }

    public void clickCookiesYesButton(){
        btnCookiesYes.click();
    }
}
