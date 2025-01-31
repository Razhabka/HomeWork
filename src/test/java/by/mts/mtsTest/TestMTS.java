package by.mts.mtsTest;

import by.mts.core.SetUpDriver;
import by.mts.pages.MainPage;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class TestMTS extends SetUpDriver {

    @Test
    @Description("Проверка названия блока")
    public void nameCheckTest() {
        MainPage mainPage = new MainPage();
        WebElement element = webDriver.findElement(By.xpath("//div[@class='pay__wrapper']/h2"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("Онлайн пополнение\nбез комиссии", element.getText()),
                () -> Assertions.assertNotNull(element.getSize())
        );

    }


    @Test

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
    @Description("Проверка ссылки (Подробнее о сервисах)")
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
    @Description("Проверка полей и кнопки")
    public void fieldTest() {
        MainPage mainPage = new MainPage();
        String phoneNumber = "297777777";
        String sum = "100";
        String expected = sum + "375" + phoneNumber;
        Assertions.assertEquals(expected, mainPage.replenishment(phoneNumber, sum));


    }
}
