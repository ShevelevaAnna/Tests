package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private final IButton btnSend = getElementFactory().getButton(By.xpath("//*[contains(@class,\"help-form__send\")]"),"Send Button");
    private final ILabel lblIsHidden = getElementFactory().getLabel(By.xpath("//*[contains(@class,\"is-hidden\")]"),"Is Hidden Label");

    public HelpForm() {
        super(By.className("help-form"), "Help Form");
    }

    public void clickSendBtn(){
        btnSend.click();
    }

    public boolean isHidden() {
        return lblIsHidden.state().waitForDisplayed();
    }
}
