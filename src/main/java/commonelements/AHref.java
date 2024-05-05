package commonelements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class AHref {
    public static SelenideElement aWithText(String text) {
        return $x("//a[text()='" + text + "']").as("Ссылка с текстом: " + text);
    }
}
