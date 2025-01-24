package by.mts.mtsTest;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class MtsOnlineRepTest {
    private static WebDriver webDriver;


    public static void setDriver(WebDriver driver){
        webDriver = driver;
    }

    @BeforeAll
    public static void acceptCookie() {
        WebElement webElement = webDriver.findElement(By.id("cookie-agree"));
        webElement.click();

    }

    @Test
    @Description("Проверка названия блока")
    public void nameCheckTest() {
        String actual = webDriver.findElement(new By.ByXPath("//div[@class='pay__wrapper']/h2")).getText();
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", actual);
        System.out.println(actual);
    }


    @Test
    @Description("Проверка наличия логотипов платежных систем")
    public void checkLogoPaySys() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[1]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[2]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[3]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[4]")).isDisplayed()),
                () -> Assertions.assertTrue(webDriver.findElement(new By.ByXPath("//div[@class='pay__partners']/ul/li[5]")).isDisplayed())
        );
    }

    @Test
    @Description("Проверка ссылки (Подробнее о сервисах)")
    public void checkLink() {
        WebElement webElement = webDriver.findElement(new By.ByXPath("//div/a[@href=\"/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/\"]"));
        webElement.click();
    }

    @Test
    @Description("Проверка полей и кнопки")
    public void fieldTest() throws InterruptedException {
        WebElement phoneField = webDriver.findElement(By.id("connection-phone"));
        phoneField.click();
        phoneField.sendKeys("297777777");
        WebElement sumField = webDriver.findElement(By.id("connection-sum"));
        sumField.click();
        sumField.sendKeys("100");
        WebElement btnContinue = webDriver.findElement(new By.ByXPath("//form[1]/button[@class=\"button button__default \"]"));
        btnContinue.click();
//        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id("cc-number")));
//        String[] array = webDriver.findElement(new By.ByXPath("//div[@class='pay-description__text']")).getText().split(":");
//        System.out.println(array[1]);
//        Assertions.assertEquals("375297777777", array[1]);

    }

}
