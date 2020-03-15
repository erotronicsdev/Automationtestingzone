package com.zone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {
    private WebDriver driver;

    @FindBy(id = "header_logo")
    private WebElement homePageHeaderLogo;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[7]/div/a")
    private WebElement orderTableDelete;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[1]")
    private WebElement orderTableMinus;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr/td[5]/div/a[2]")
    private WebElement orderTablePlus;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[1]")
    private WebElement summaryTableBody;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table")
    private WebElement OrderSummaryTable;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tfoot/tr[7]/td[2]/span")
    private WebElement orderTotalText;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[2]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/p[2]/a[1]")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "email_create")
    private WebElement createEmailText;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/form/p/button")
    private WebElement processAddressButton;

    @FindBy(id = "cgv")
    private WebElement termsOfServiceCheckBox;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/p/button")
    private WebElement shippingProcessToCheckOut;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[3]/div[1]/div/p/a")
    private WebElement payByWireButton;

    private static final String CONFIRM_ORDER_BUTTON = "/html/body/div/div[2]/div/div[3]/div/form/p/button";
    @FindBy(xpath = CONFIRM_ORDER_BUTTON)
    private WebElement confirmOrderButton;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutButton;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setCreateEmail(String email) {
        createEmailText.clear();
        createEmailText.sendKeys(email);
    }

    public void clickOnCreateAccountButton() {
        createAccountButton.click();
    }

    public void clickOnPrceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickOnProcessAddressButton() {
        processAddressButton.click();
    }

    public void clickOnTermsOfServiceCheckbox() {
        termsOfServiceCheckBox.click();
    }

    public void clickOnShippingProcessToCheckOut() {
        shippingProcessToCheckOut.click();
    }

    public void clickOnPayNyWireButton() {
        payByWireButton.click();
    }

    public void clickOnConfirmOrderButton() {
        confirmOrderButton.click();
    }

    public void clickOnSignOutButton() {
        signOutButton.click();
    }
    public void waitOnProceedToCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CONFIRM_ORDER_BUTTON)));
    }
}
