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
    @Description("Проверка названия блока")
    public void nameCheckTest() {
        WebElement element = webDriver.findElement(new By.ByXPath("//div[@class='pay__wrapper']/h2"));
        Assertions.assertAll(
                () -> Assertions.assertEquals("Онлайн пополнение\nбез комиссии", element.getText()),
                () -> Assertions.assertNotNull(element.getSize())
        );

    }


    @Test
    @Description("Проверка наличия логотипов платежных систем")
    public void checkLogoPaySys() {
        Assertions.assertAll(
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[1]")).getSize()),
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[2]")).getSize()),
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[3]")).getSize()),
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[4]")).getSize()),
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[5]")).getSize())
        );
    }

    @Test
    @Description("Проверка ссылки (Подробнее о сервисах)")
    public void checkLink() {
        WebElement webElement = webDriver.findElement(new By.ByXPath("//div/a[@href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\"]"));
        webElement.click();
        Assertions.assertAll(
                () -> Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", webDriver.getCurrentUrl()),
                () -> Assertions.assertEquals("Порядок оплаты и безопасность интернет платежей", webDriver.getTitle()),
                () -> Assertions.assertTrue(() -> webDriver.findElement(new By.ByXPath("//div[4][@class='container-fluid']")).isDisplayed()),
                () -> Assertions.assertNotNull(webDriver.findElement(new By.ByXPath("//div[4][@class='container-fluid']")).getSize())
        );
    }

    @Test
    @Description("Проверка полей и кнопки")
    public void fieldTest() {
        String phoneNumber = "297777777";
        String sum = "100";
        String expected = sum + "375" + phoneNumber;
        Assertions.assertEquals(expected, mainPage.replenishment(phoneNumber, sum));


    }
}
