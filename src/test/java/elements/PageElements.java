package elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class PageElements {

    @Step("Выбрать вариант в навигационном меню")
    public PageElements clickTab(int index, String variant) {
        ElementsCollection tabs = $$x("//span[@class='main-menu-navigation__item-inner']");
        tabs.get(index).shouldHave(text(variant)).click();
        return this;
    }

    @Step("Выбрать опцию")
    public PageElements clickOption(String option) {
        SelenideElement choiceApp = $x("//div[contains(text(), " + "'" + option + "'" + ")]");
        choiceApp.click();
        return this;
    }

    @Step("Выбрать приложение")
    public PageElements clickApp(String app) {
        SelenideElement mtsApp = $x("//span[contains(text(), " + "'" + app + "'" + ")]");
        mtsApp.click();
        return this;
    }

    @Step("Открыть куар-код")
    public PageElements clickQRCode() {
        SelenideElement qrCode = $x("//div[@class='link_pseudo']").shouldHave(text("Показать QR-код"));
        qrCode.click();
        return this;
    }

    @Step("Узнать размер куар-кода")
    public Dimension getDimension() {
        Dimension dimension = $x("//div[@class='modal__qr']").getSize();
        return dimension;
    }

}

