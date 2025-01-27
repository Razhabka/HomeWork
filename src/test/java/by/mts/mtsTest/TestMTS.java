package by.mts.mtsTest;

import by.mts.core.SetUpDriver;
import by.mts.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


public class TestMTS extends SetUpDriver {

    private final MainPage mainPage = new MainPage();

    @Test
    @Description("Проверка надписи полей 'Услуга связи'")
    public void comServiceTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер телефона", mainPage.communSeviceText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.communSeviceText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.communSeviceText()[2])
        );
    }

    @Test
    @Description("Проверка надписи полей'Домашний интернет'")
    public void homeInternetTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер абонента", mainPage.homeNetText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.homeNetText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.homeNetText()[2])
        );
    }

    @Test
    @Description("Проверка надписей полей 'Рассрочка'")
    public void installmentTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 44", mainPage.installmentText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.installmentText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.installmentText()[2])
        );
    }

    @Test
    @Description("Проверка надписей полей 'Рассрочка'")
    public void arrearsTest() {
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер счета на 2073", mainPage.arrearsText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.arrearsText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.arrearsText()[2])
        );
    }

    @Test
    @Description("Проверка меню заполнения реквезитов")
    public void depositTest() {
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
                () -> Assertions.assertNotEquals("", actual.get("Visa icon")),
                () -> Assertions.assertNotEquals("", actual.get("Mastercard icon")),
                () -> Assertions.assertNotEquals("", actual.get("Belkart icon")),
                () -> Assertions.assertNotEquals("", actual.get("Mir icon"))
        );
    }
}
