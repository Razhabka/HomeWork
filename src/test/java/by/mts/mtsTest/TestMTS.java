package by.mts.mtsTest;

import by.mts.core.SetUpDriver;
import by.mts.core.TestListener;
import by.mts.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

@ExtendWith(TestListener.class)
public class TestMTS extends SetUpDriver {

    @Test
    @DisplayName("Проверка плэйсхолдеров полей \"Услуги связи\"")
    @Description("")
    public void comServiceTest() {
        MainPage mainPage = new MainPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номvер телефона", mainPage.communSeviceText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.communSeviceText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.communSeviceText()[2])
        );
    }

    @Test
    @DisplayName("Проверка надписи полей\"Домашний интернет\"")
    @Description("")
    public void homeInternetTest() {
        MainPage mainPage = new MainPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер абонента", mainPage.homeNetText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.homeNetText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.homeNetText()[2])
        );
    }

    @Test
    @DisplayName("Проверка надписей полей \"Рассрочка\"")
    @Description("")
    public void installmentTest() {
        MainPage mainPage = new MainPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 44", mainPage.installmentText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.installmentText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.installmentText()[2])
        );
    }

    @Test
    @DisplayName("Проверка надписей полей \"Задолженность\"")
    @Description("")
    public void arrearsTest() {
        MainPage mainPage = new MainPage();
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 2073", mainPage.arrearsText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.arrearsText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.arrearsText()[2])
        );
    }

    @Test
    @DisplayName("Проверка меню заполнения реквезитов")
    @Description("")
    public void depositTest() {
        MainPage mainPage = new MainPage();
        String phoneNumber = "297777777";
        String value = "100.00";
        HashMap<String, String> actual = mainPage.depositPopUpMenu(phoneNumber, value);
        Assertions.assertAll(
                () -> Assertions.assertEquals(375 + phoneNumber, actual.get("Phone number")),
                () -> Assertions.assertEquals(value, actual.get("Deposit sum")),
                () -> Assertions.assertEquals("Номер карты", actual.get("Card number placeholder")),
                () -> Assertions.assertEquals("Срок действия", actual.get("Validity period placeholder")),
                () -> Assertions.assertEquals("CVC", actual.get("CVC placeholder")),
                () -> Assertions.assertEquals("Имя держателя (как на карте)", actual.get("Holder's name placeholder")),
                () -> Assertions.assertEquals(value, actual.get("Deposit sum on button")),
                () -> Assertions.assertEquals("true", actual.get("Visa icon")),
                () -> Assertions.assertEquals("true", actual.get("Mastercard icon")),
                () -> Assertions.assertEquals("true", actual.get("Belkart icon")),
                () -> Assertions.assertEquals("true", actual.get("Mir icon")),
                () -> Assertions.assertThrows(Exception.class, () -> webDriver.findElement(By.xpath("//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img[4]"))),
                () -> Assertions.assertThrows(Exception.class, () -> webDriver.findElement(By.xpath("//div[@class='cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted']/img[3]")))
        );
    }

    //Тесты из 15 работы
    @Test
    @DisplayName("Проверка названия блока оплаты")
    @Description("")
    public void nameCheckTest() {
        MainPage mainPage = new MainPage();
        WebElement element = webDriver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("Онлайн пополнение\nбез комиссии", element.getText()),
                () -> Assertions.assertNotNull(element.getSize())
        );

    }
    @Test
    @DisplayName("Проверка отображения логотипов платежный систем")
    public void checkLogoPaySys() {
        MainPage mainPage = new MainPage();
        Assertions.assertAll(
                () -> Assertions.assertTrue(webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[1]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[2]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[3]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[4]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[5]")).isDisplayed()),
                () -> Assertions.assertThrows(Exception.class, () -> webDriver.findElement(By.xpath("//div[@class='pay__partners']/ul/li[6]")))
        );
    }

    @Test
    @DisplayName("Проверка ссылки \"Подробнее о сервисах\"")
    public void checkLink() {
        MainPage mainPage = new MainPage();
        WebElement webElement = webDriver.findElement(By.xpath("//div/a[@href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\"]"));
        webElement.click();
        mainPage.acceptCookies();
        Assertions.assertAll(
                () -> Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", webDriver.getCurrentUrl()),
                () -> Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", webDriver.getTitle()),
                () -> Assertions.assertTrue(() -> webDriver.findElement(By.xpath("//div[4][@class='container-fluid']")).isDisplayed()),
                () -> Assertions.assertNotNull(webDriver.findElement(By.xpath("//div[4][@class='container-fluid']")).getSize())
        );
    }

    @Test
    @DisplayName("Проверка полей и кнопки")
    public void fieldTest() {
        MainPage mainPage = new MainPage();
        String phoneNumber = "297777777";
        String sum = "100";
        Assertions.assertEquals(sum + "375" + phoneNumber, mainPage.replenishment(phoneNumber, sum));


    }


}
