package com.zone.autotests;

import com.zone.pages.CreateAccountForm;
import com.zone.pages.HomePage;
import com.zone.pages.ProductPage;
import com.zone.pages.SummaryPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.security.SecureRandom;

import java.util.concurrent.TimeUnit;

public class ZoneTests {

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER = "0123456789";
    private static final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + NUMBER;
    private static SecureRandom random = new SecureRandom();
    private WebDriver driver;
    private String emailToRegister;

    @Before
    public void setup() {
        //use FF Driver
        System.setProperty("webdriver.gecko.driver","/Users/User/Documents/workspace/automationtestingzone/src/test/resources/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void newUserOrderRegister() {
        HomePage home = new HomePage(driver);
        home.clickfirstImageInQuickView();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ProductPage prodPage = new ProductPage(driver);
        prodPage.setColorPicker(2);
        prodPage.setSelectSizeDropDown("2");
        prodPage.clickOnAddToCartButton();
        prodPage.waitOnProceedToCheckoutButton();
        prodPage.clickOnProceedToCheckoutButton();

        SummaryPage sumPage = new SummaryPage(driver);
        sumPage.clickOnPrceedToCheckoutButton();
        emailToRegister = generateRandomEmail(8);
        sumPage.setCreateEmail(emailToRegister);
        sumPage.clickOnCreateAccountButton();

        CreateAccountForm createAccountForm = new CreateAccountForm(driver);
        createAccountForm.setRadioGender();
        createAccountForm.setCustomerFirstNameText("Jumpy");
        createAccountForm.setCustomerLastNameText("Johny");
        createAccountForm.setPasswordText("stuff123");
        createAccountForm.setDateOfBirthDaysMenu("10");
        createAccountForm.setDateOfBirthMonthsMenu("10");
        createAccountForm.setDateOfBirthYearsMenu("1970");
        createAccountForm.setAddressFirstNameText("jumpy");
        createAccountForm.setAddressLastNameText("johny");
        createAccountForm.setAddressLineOneText("711-2880 Nulla St.");
        createAccountForm.setAddressLineTwoText("");
        createAccountForm.setCityText("Mankato");
        createAccountForm.setStateMenu("24");
        createAccountForm.setPostCodeText("96522");
        createAccountForm.setCountryMenu("21");
        createAccountForm.setMobilePhoneText("(257) 563-7401");
        createAccountForm.setAddressAliasText("jumpy");
        createAccountForm.clickSubmitAccountButton();

        sumPage.clickOnProcessAddressButton();
        sumPage.clickOnTermsOfServiceCheckbox();
        sumPage.clickOnShippingProcessToCheckOut();
        sumPage.clickOnPayNyWireButton();
        sumPage.clickOnConfirmOrderButton();

        sumPage.clickOnSignOutButton();
    }

        @After
        public void close(){
            driver.close();
        }

    private static String generateRandomEmail(int length) {
        if (length < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {

            int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
            char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);
            sb.append(rndChar);
        }
        sb.append("@zonetest.com");
        return sb.toString();
    }
}
