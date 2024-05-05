package commonelements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class P {
    public static SelenideElement pWithText(String text) {
        return $x("//p[text()='" + text + "']").as("Элемент 'P' с текстом: " + text);
    }
}
