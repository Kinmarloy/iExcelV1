package pages;

import com.codeborne.selenide.Selenide;

public class MainPage {

    public MainPage open(String url) {
        Selenide.open(url);
        return this;
    }
}
