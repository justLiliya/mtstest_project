package tests;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest extends TestBase {


    @Test
    @Description("Открывается куар-код корректного размера")
    @DisplayName("Получение куар-кода по ссылке")
    void getQRcodeTest() throws InterruptedException {
        open("");
        Thread.sleep(50);
        Dimension trueSize = new Dimension(1148, 1148);

        step("Предусловия: переход в Сервисы и подписки >>> Приложения от МТС >>> МТС Бизнес", () -> {
            ElementsCollection tabs = $$x("//span[@class='main-menu-navigation__item-inner']");
            tabs.get(2).shouldHave(text("Сервисы и подписки")).click();
            $x("//div[contains(text(),'Приложения от МТС')]").click();
            Thread.sleep(50);
            $x("//span[contains(text(),'МТС Бизнес')]").click();
            Thread.sleep(50);
        });


        step("Открываем куар-код и проверяем, что его размер соответствует требованиям", () -> {
            $x("//div[@class='link_pseudo']").shouldHave(text("Показать QR-код")).click();
           Dimension hight =  $x("//div[@class='modal__qr']").getSize();
           assertEquals(hight, trueSize);
        });

    }

}
