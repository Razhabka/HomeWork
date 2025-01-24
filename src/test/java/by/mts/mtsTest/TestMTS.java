package by.mts.mtsTest;

import by.mts.core.SetUpDriver;
import by.mts.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestMTS extends SetUpDriver {

    private final MainPage mainPage = new MainPage();

    @Test
    @Description("Проверка надписи полей 'Услуга связи'")
    public void comServiceTest(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("Номер телефона", mainPage.communSeviceText()[0]),
                () -> Assertions.assertEquals("Сумма", mainPage.communSeviceText()[1]),
                () -> Assertions.assertEquals("E-mail для отправки чека", mainPage.communSeviceText()[2])
        );
    }
    @Test
    @Description("Проверка надписи полей'Домашний интернет'")
    public void homeInternetTest(){
        Assertions.assertAll(
                ()->Assertions.assertEquals("Номер абонента", mainPage.homeNetText()[0]),
                ()->Assertions.assertEquals("Сумма", mainPage.homeNetText()[1]),
                ()->Assertions.assertEquals("E-mail для отправки чека", mainPage.homeNetText()[2])
        );
    }

    @Test
    @Description("Проверка надписей полей 'Рассрочка'")
    public void installmentTest(){
        Assertions.assertAll(
                ()->Assertions.assertEquals("Номер счета на 44", mainPage.installmentText()[0]),
                ()->Assertions.assertEquals("Сумма", mainPage.installmentText()[1]),
                ()->Assertions.assertEquals("E-mail для отправки чека", mainPage.installmentText()[2])
        );
    }

    @Test
    @Description("Проверка надписей полей 'Рассрочка'")
    public void arrearsTest(){
        Assertions.assertAll(
                ()->Assertions.assertEquals("Номер счета на 2073", mainPage.arrearsText()[0]),
                ()->Assertions.assertEquals("Сумма", mainPage.arrearsText()[1]),
                ()->Assertions.assertEquals("E-mail для отправки чека", mainPage.arrearsText()[2])
        );
    }
}
