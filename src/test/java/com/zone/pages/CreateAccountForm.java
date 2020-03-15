package com.zone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccountForm {
    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement radioGenderMr;

    @FindBy(id = "id_gender2")
    private WebElement radioGenderMrs;

    @FindBy(id = "customer_firstname")
    private WebElement customerFirstNameText;

    @FindBy(id = "customer_lastname")
    private WebElement customerLastNameText;

    @FindBy(id = "passwd")
    private WebElement passwordText;

    @FindBy(id = "days")
    private WebElement dateOfBirthDaysMenu;

    @FindBy(id = "months")
    private WebElement dateOfBirthMonthsMenu;

    @FindBy(id = "years")
    private WebElement dateOfBirthYearsMenu;

    @FindBy(id = "firstname")
    private WebElement addressFirstNameText;

    @FindBy(id = "lastname")
    private WebElement addressLastNameText;

    @FindBy(id = "address1")
    private WebElement addressLineOneText;

    @FindBy(id = "address2")
    private WebElement addressLineTwoText;

    @FindBy(id = "city")
    private WebElement cityText;

    @FindBy(id = "id_country")
    private WebElement countryMenu;

    @FindBy(id = "postcode")
    private WebElement postCodeText;

    @FindBy(id = "id_state")
    private WebElement stateMenu;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneText;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/div[2]/p[14]/input")
    private WebElement addressAliasText;

    @FindBy(id = "submitAccount")
    private WebElement submitAccountButton;

    public CreateAccountForm(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void setRadioGender() {
        radioGenderMr.click();
    }

    public void setCustomerFirstNameText(String customerFirstName) {
        customerFirstNameText.clear();
        customerFirstNameText.sendKeys(customerFirstName);
    }

    public void setCustomerLastNameText(String customerLastName) {
        customerLastNameText.clear();
        customerLastNameText.sendKeys(customerLastName);
    }

    public void setPasswordText(String password) {
        passwordText.clear();
        passwordText.sendKeys(password);
    }

    public void setDateOfBirthDaysMenu(String dayOfBirth) {
        Select days = new Select(dateOfBirthDaysMenu);
        days.selectByValue(dayOfBirth);
    }

    public void setDateOfBirthMonthsMenu(String monthOfBirth) {
        Select monthSelect = new Select(dateOfBirthMonthsMenu);
        monthSelect.selectByValue(monthOfBirth);
    }

    public void setDateOfBirthYearsMenu(String yearOfBirth) {
        Select yearSelect = new Select(dateOfBirthYearsMenu);
        yearSelect.selectByValue(yearOfBirth);
    }

    public void setAddressFirstNameText(String addressFirstName) {
        addressFirstNameText.clear();
        addressFirstNameText.sendKeys(addressFirstName);
    }

    public void setAddressLastNameText(String addressLastName) {
        addressLastNameText.clear();
        addressLastNameText.sendKeys(addressLastName);
    }

    public void setAddressLineOneText(String addressLineOne) {
        addressLineOneText.clear();
        addressLineOneText.sendKeys(addressLineOne);
    }

    public void setAddressLineTwoText(String addressLineTwo) {
        addressLineTwoText.clear();
        addressLineTwoText.sendKeys(addressLineTwo);
    }

    public void setCityText(String city) {
        cityText.clear();
        cityText.sendKeys(city);
    }

    public void setCountryMenu(String country) {
        Select countrySelect = new Select(countryMenu);
        countrySelect.selectByValue(country);
    }

    public void setStateMenu(String state) {
        Select stateSelect = new Select(stateMenu);
        stateSelect.selectByValue(state);
    }

    public void setPostCodeText(String postCode) {
        postCodeText.clear();
        postCodeText.sendKeys(postCode);
    }

    public void setMobilePhoneText(String mobilePhone) {
        mobilePhoneText.clear();
        mobilePhoneText.sendKeys(mobilePhone);
    }

    public void setAddressAliasText(String addressAlias) {
        addressAliasText.clear();
        addressAliasText.sendKeys(addressAlias);
    }

    public void clickSubmitAccountButton() {
        submitAccountButton.click();
    }

}
