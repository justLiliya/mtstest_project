package tests;

import elements.PageElements;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsBusinessPageTest extends TestBase {

    PageElements pageElements = new PageElements();


    @Test
    @Description("Открывается куар-код корректного размера")
    void getQRcodeTest() {
        Dimension trueSize = new Dimension(1148, 1148);
        pageElements.clickTab(2, "Сервисы и подписки");
        pageElements.clickOption("Приложения от МТС");
        pageElements.clickApp("МТС Бизнес");

        step("Открываем куар-код и проверяем, что его размер соответствует требованиям", () -> {
            pageElements.clickQRCode();
            assertEquals(pageElements.getDimension(), trueSize);
        });

    }

}
