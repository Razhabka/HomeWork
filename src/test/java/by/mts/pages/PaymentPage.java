package by.mts.pages;

import by.mts.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class PaymentPage{
//    Кнопки
    @FindBy(xpath = "//button[@class='colored disabled']")
    WebElement payBtn;
    //    плэйс-холдеры с попап меню

    @FindBy(xpath = "//div[@class='pay-description__text']/span")
    private WebElement payDescriptionNumber;

    @FindBy(xpath = "//div[@class='pay-description__cost']/span")
    private WebElement payDescriptionSum;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-1']/label[1]")
    private WebElement numberCardField;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-4']/label")
    private WebElement validityPeriodFiled;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-5']/label")
    private WebElement cvcFiled;

    @FindBy(xpath = "//div[@class='content ng-tns-c46-3']/label")
    private WebElement nameHolderField;

//    Иконки платежных систем

    @FindBy(xpath = "//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img[1]")
    private WebElement firstIconOnField;

    @FindBy(xpath = "//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img[2]")
    private WebElement secondIconOnField;

    @FindBy(xpath = "//div[@class='cards-brands cards-brands__container ng-tns-c61-0 ng-trigger ng-trigger-brandsState ng-star-inserted']/img[3]")
    private WebElement thirdOnField;

    @FindBy(xpath = "//div[@class='cards-brands cards-brands_random ng-tns-c61-0 ng-star-inserted']/img")
    private WebElement fourthIconOnField;

    public PaymentPage() {
        PageFactory.initElements(MainPage.getDriver(), this);
    }

    public HashMap windowEnteringBankDetails(){
        HashMap<String, String> allItems = new HashMap<>();
        allItems.put("Phone number", payDescriptionNumber.getText().split(":")[2]);
        allItems.put("Deposit sum", payDescriptionSum.getText().split(" ")[0]);
        allItems.put("Card number placeholder", numberCardField.getText());
        allItems.put("Validity period placeholder", validityPeriodFiled.getText());
        allItems.put("CVC placeholder", cvcFiled.getText());
        allItems.put("Holder's name placeholder", nameHolderField.getText());
        allItems.put("Deposit sum on button", payBtn.getText().split(" ")[1]);
        allItems.put("Visa icon", Boolean.toString(firstIconOnField.isDisplayed()));
        allItems.put("Mastercard icon", Boolean.toString(secondIconOnField.isDisplayed()));
        allItems.put("Belkart icon", Boolean.toString(thirdOnField.isDisplayed()));
        allItems.put("Mir icon", Boolean.toString(fourthIconOnField.isDisplayed()));

        return allItems;
    }

    public String getTextSumAndNumber(){
        return payDescriptionSum.getText().split("\\.")[0] + payDescriptionNumber.getText().split(":")[2];
    }

}
