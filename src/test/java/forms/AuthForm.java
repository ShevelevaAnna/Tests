package forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class AuthForm extends Form {
    private final ITextBox tbPassword = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder,\"Password\")]"),"Password");
    private final ITextBox tbEmail = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder,\"email\")]"),"Email");
    private final ITextBox tbDomain = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder,\"Domain\")]"),"Domain");
    private final IButton btnDomainList = getElementFactory().getButton(By.className("dropdown__opener"), "Domain List Button");
    private final IButton btnDomainListItem = getElementFactory().getButton(By.xpath("//*[@class=\"dropdown__list\"]"), "Domain List Item Button");
    private final IButton btnNext = getElementFactory().getButton(By.className("button--secondary"), "Next Button");
    private final ICheckBox chbAccept = getElementFactory().getCheckBox(By.className("checkbox__box"),"Accept Check Box");
    private final ILabel lblTimer = getElementFactory().getLabel(By.xpath("//*[contains(@class,\"timer\")]"),"Timer");

    private final String childPathBtnDomainListItem = "//div[%d]";

    public AuthForm() {
        super(By.className("login-form"),"Login Form");
    }

    public void inputData(String password, String email, String domain){
        tbPassword.clearAndType(password);
        tbEmail.clearAndType(email);
        tbDomain.clearAndType(domain);
    }

    public void clickDomain(int domain_item){
        btnDomainList.click();
        btnDomainListItem.findChildElement(By.xpath(String.format(childPathBtnDomainListItem,domain_item)), ElementType.CHECKBOX).click();
    }

    public void uncheckCheckBox(){
        chbAccept.click();
    }

    public void clickNext(){
        btnNext.click();
    }

    public String getTextTimer(){
        return lblTimer.getText();
    }
}
