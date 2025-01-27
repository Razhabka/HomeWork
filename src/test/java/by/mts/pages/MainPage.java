package by.mts.pages;

import by.mts.core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//button[@class='colored disabled']")
    WebElement payBtn;

    //    плэйс-холдеры с попап меню

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionNumber;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement payDescriptionSum;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-1']/label[1]")
    WebElement numberCardField;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-4']/label")
    WebElement validityPeriodFiled;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-5']/label")
    WebElement cvcFiled;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-3']/label")
    WebElement nameHolderField;

//    Иконки платежных систем

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]")
    WebElement firstIconOnField;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]")
    WebElement secondIconOnField;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]")
    WebElement thirdOnField;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div")
    WebElement fourthIconOnField;



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
        HashMap<String, String> allItems = new HashMap<>();
        allItems.put("Phone number", payDescriptionNumber.getText().split(":")[2]);
        allItems.put("Deposit sum", payDescriptionSum.getText().split(" ")[0]);
        allItems.put("Card number placeholder", numberCardField.getText());
        allItems.put("Validity period placeholder", validityPeriodFiled.getText());
        allItems.put("CVC placeholder", cvcFiled.getText());
        allItems.put("Holder's name placeholder", nameHolderField.getText());
        allItems.put("Deposit sum on button", payBtn.getText().split(" ")[1]);
        allItems.put("Visa icon", firstIconOnField.getSize().toString());
        allItems.put("Mastercard icon", secondIconOnField.getSize().toString());
        allItems.put("Belkart icon", thirdOnField.getSize().toString());
        allItems.put("Mir icon", fourthIconOnField.getSize().toString());
        return allItems;
    }


    private static void acceptCookies() {
        try {
            WebElement webElement = driver.findElement(By.id("cookie-agree"));
            webElement.click();
        } catch (NoSuchElementException | ElementNotInteractableException |StaleElementReferenceException e) {
        }
    }
}
