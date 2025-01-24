package by.mts.pages;

import by.mts.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement payWrapper;

    @FindBy(id = "connection-phone")
    private WebElement phoneNumberField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(xpath = "//form[1]/button[@class='button button__default ']")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionNumber;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement payDescriptionSum;


    public MainPage() {
        driver.get("https://www.mts.by/");
        PageFactory.initElements(driver, this);
        acceptCookies();
    }


    public String replenishment(String phoneNumber, String sum) {

        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);
        sumField.click();
        sumField.sendKeys(sum);
        continueBtn.click();
        driver.switchTo().frame(driver.findElement(new By.ByXPath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//div[@class='pay-description__text']/span")));
        return getSumAndNumberPhone(payDescriptionSum.getText(), payDescriptionNumber.getText());
    }

    private String getSumAndNumberPhone(String sum, String numberPhone) {
        String[] splitSum = sum.split("\\.");
        String[] splitNumber = numberPhone.split(":");
        return splitSum[0] + splitNumber[2];
    }

    private static void acceptCookies() {

        try {
            WebElement webElement = driver.findElement(By.id("cookie-agree"));
            webElement.click();
        } catch (NoSuchElementException | ElementNotInteractableException e) {

        }
    }
}
