package commonelements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Input {
    public static SelenideElement inputName(String text, String description) {
        return $x("//input[@name='" + text + "']").as("Поле ввода: " + description);
    }
}
