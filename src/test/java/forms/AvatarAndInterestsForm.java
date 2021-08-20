package forms;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AvatarAndInterestsForm extends Form {
    private final IButton btnUpload = getElementFactory().getButton(By.xpath("//a[contains(@class,\"upload-button\")]"),"Upload Button");
    private final IButton btnNext = getElementFactory().getButton(By.xpath("//*[contains(@class,\"button--stroked\")]"),"Next Button");
    private final ICheckBox chbInterest = getElementFactory().getCheckBox(By.className("avatar-and-interests__interests-list"),"Interest Check Box");

    private final int[] PATH_FIELD_COORD = {1000, 150};
    private final int[] ACCEPT_COORD = {1400, 900};
    private final String childPathChBInterest = "//div[%d]//span";

    public AvatarAndInterestsForm() { super(By.className("avatar-and-interests"),"Avatar and Interests Form"); }

    public void clickUploadBtn() { btnUpload.click(); }

    public void uploadIMG(String fullPathImg){
        try {
            Robot robot = new Robot();
            StringSelection ss = new StringSelection(fullPathImg);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

            int mask = InputEvent.BUTTON1_DOWN_MASK;

            robot.mouseMove(PATH_FIELD_COORD[0], PATH_FIELD_COORD[1]);
            robot.mousePress(mask);
            robot.mouseRelease(mask);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            robot.mouseMove(ACCEPT_COORD[0], ACCEPT_COORD[1]);
            robot.mousePress(mask);
            robot.mouseRelease(mask);
            robot.mousePress(mask);
            robot.mouseRelease(mask);
            robot.mousePress(mask);
            robot.mouseRelease(mask);
            robot.mousePress(mask);
            robot.mouseRelease(mask);

        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void clickInterestCheckBox(int number){
        chbInterest.findChildElement(By.xpath(String.format(childPathChBInterest,number)), ElementType.CHECKBOX).click();
    }
    public void clickNextButton(){
        btnNext.click();
    }

}
