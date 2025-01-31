package by.mts.pages;

import by.mts.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.naming.ldap.LdapReferralException;
import javax.swing.text.html.Option;
import java.time.Duration;
import java.util.HashMap;

public class MainPage extends BasePage {
    @FindBy(id = "connection-phone")
    private WebElement phoneNumberField;

    @FindBy(id = "connection-sum")
    private WebElement sumField;

    @FindBy(id = "connection-email")
    private WebElement emailField;

    @FindBy(id = "internet-phone")
    private WebElement internetPhone;

    @FindBy(id = "internet-sum")
    private WebElement internetSum;

    @FindBy(id = "internet-email")
    private WebElement internetEmail;

    @FindBy(id = "score-instalment")
    private WebElement instalmentScore;

    @FindBy(id = "instalment-sum")
    private WebElement instalmentSum;

    @FindBy(id = "instalment-email")
    private WebElement instalmentEmail;

    @FindBy(id = "score-arrears")
    private WebElement arrearsScore;

    @FindBy(id = "arrears-sum")
    private WebElement arrearsSum;

    @FindBy(id = "arrears-email")
    private WebElement arrearsEmail;

    @FindBy(xpath = "//form[1]/button[@class='button button__default ']")
    private WebElement continueBtn;

    @FindBy(xpath = "//button[@class='select__header']")
    private WebElement selectHeaderBtn;

    @FindBy(xpath = "//ul[@class='select__list']/li[2]")
    private WebElement homeInternet;

    @FindBy(xpath = "//ul[@class='select__list']/li[3]")
    private WebElement instalmentBtn;

    @FindBy(xpath = "//ul[@class='select__list']/li[4]")
    private WebElement arrearsBtn;



    public MainPage() {
        driver.get("https://www.mts.by");
        PageFactory.initElements(driver, this);
        acceptCookies();
    }

    public String[] communSeviceText() {
        String[] allPlaceHolders = new String[3];
        allPlaceHolders[0] = phoneNumberField.getAttribute("placeholder");
        allPlaceHolders[1] = sumField.getAttribute("placeholder");
        allPlaceHolders[2] = emailField.getAttribute("placeholder");
        return allPlaceHolders;
    }

    public String[] homeNetText() {
        selectHeaderBtn.click();
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(new By.ByXPath("//li[2][@class='select__item active']")));
        homeInternet.click();
//        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("internet-phone")));
        String[] allPlaceHolders = new String[3];
        allPlaceHolders[0] = internetPhone.getAttribute("placeholder");
        allPlaceHolders[1] = internetSum.getAttribute("placeholder");
        allPlaceHolders[2] = internetEmail.getAttribute("placeholder");
        return allPlaceHolders;

    }

    public String[] installmentText() {
        selectHeaderBtn.click();
        instalmentBtn.click();

        String[] allPlaceHolders = new String[3];
        allPlaceHolders[0] = instalmentScore.getAttribute("placeholder");
        allPlaceHolders[1] = instalmentSum.getAttribute("placeholder");
        allPlaceHolders[2] = instalmentEmail.getAttribute("placeholder");
        return allPlaceHolders;
    }

    public String[] arrearsText() {
        selectHeaderBtn.click();
        arrearsBtn.click();

        String[] allPlaceHolders = new String[3];
        allPlaceHolders[0] = arrearsScore.getAttribute("placeholder");
        allPlaceHolders[1] = arrearsSum.getAttribute("placeholder");
        allPlaceHolders[2] = arrearsEmail.getAttribute("placeholder");
        return allPlaceHolders;
    }

    public HashMap depositPopUpMenu(String phoneNumber, String depositValue) {
        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);
        sumField.click();
        sumField.sendKeys(depositValue);
        continueBtn.click();
        driver.switchTo().frame(driver.findElement(new By.ByXPath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(new By.ByXPath("//div[@class='pay-description__text']/span")));
        PaymentPage paymentPage = new PaymentPage();

        return paymentPage.windowEnteringBankDetails();
    }

    public String replenishment(String phoneNumber, String sum) {

        phoneNumberField.click();
        phoneNumberField.sendKeys(phoneNumber);
        sumField.click();
        sumField.sendKeys(sum);
        continueBtn.click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='bepaid-iframe']")));
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay-description__text']/span")));
        PaymentPage paymentPage = new PaymentPage();
        return paymentPage.getTextSumAndNumber();
    }


    public static WebDriver getDriver(){
        return driver;
    }


    public static void acceptCookies() {
        try {
            WebElement webElement = driver.findElement(By.id("cookie-agree"));
            webElement.click();
        } catch (NoSuchElementException | ElementNotInteractableException |StaleElementReferenceException e) {
        }
    }
}
