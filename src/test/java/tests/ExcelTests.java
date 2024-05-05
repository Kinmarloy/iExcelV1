package tests;

import com.codeborne.selenide.Condition;
import helpers.WebHooks;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ExcelTests extends WebHooks {

    @Test
    public void NewExcel() throws AWTException {

        String username = "admin@clicklead.tech";
        String password = "t$d8ewvnE*uZTKL";


//        open("https://www.data.ai/");
//        $x("//a[@href='https://www.data.ai/account/login']").shouldBe(Condition.visible, Duration.ofSeconds(1000)).click();

        open("https://google.com");

//        Robot r = new Robot();
//        r.keyPress(KeyEvent.VK_TAB);
//        r.keyPress(KeyEvent.VK_TAB);
//        r.keyPress(KeyEvent.VK_ENTER);
//        sleep(10000);

//        $x("//button[@id='onetrust-accept-btn-handler']").shouldBe(Condition.visible, Duration.ofSeconds(1000)).click();  //Блокирует доступ к сайту

//        $x("//input[@name='username']").shouldBe(Condition.visible, Duration.ofSeconds(1000)).setValue(username);
//        $x("//input[@placeholder='Password']").shouldBe(Condition.visible, Duration.ofSeconds(1000)).setValue(password);
////        $x("//button[@type='submit']").shouldBe(Condition.visible, Duration.ofSeconds(1000)).click(); //Блокирует доступ к сайту
//        sleep(20000);
//
//        $x("(//a[@aria-label='Просмотреть больше'])[1]").shouldBe(Condition.visible, Duration.ofSeconds(1000)).click();
//        sleep(10000);

    }
}

