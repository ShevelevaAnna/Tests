package forms;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class StartForm extends Form{
    private final  ILink linkNext = getElementFactory().getLink(By.xpath("//a[@href=\"/game.html\"]"), "Next");

    public StartForm() {
        super(By.xpath("//*[contains(@class,\"start view\")]"), "Start Form");
    }

    public void clickLinkNext(){
        linkNext.clickAndWait();
    }
}
