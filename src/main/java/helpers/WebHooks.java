package helpers;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;


public class WebHooks {

    @BeforeEach
    public void setupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver124.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars",
                "--incognito",
                "--disable-translate",
                "--disable-web-security");
        Configuration.browserCapabilities = chromeOptions;
        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        Configuration.timeout = 50000;
        Configuration.pageLoadTimeout = 120000;
    }

    @AfterEach
    public void closeDriver() {
        Selenide.closeWebDriver();
    }

    public void open(String url) {
        Selenide.open(url);
    }

    public void refresh() {
        Selenide.refresh();
    }
}