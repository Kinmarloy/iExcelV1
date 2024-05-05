package tests;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class RobotUseKeys {

    @Test
    public void NewExcel() throws AWTException {

        open("https://google.com");

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_TAB);
        r.keyPress(KeyEvent.VK_ENTER);
        sleep(10000);
    }
}
