package com.zone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage {
    private WebDriver driver;

    @FindBy(id = "header_logo")
    private WebElement homePageHeaderLogo;

    @FindBy(id = "quantity_wanted_p")
    private WebElement quantityField;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[1]")
    private WebElement quantityMinusButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[1]/div/div/select")
    private WebElement selectSizeDropDown;

    private static final String PROCCEED_TO_CHECKOUT_BUTTON_XPATH = "/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a";
    @FindBy(xpath = PROCCEED_TO_CHECKOUT_BUTTON_XPATH)
    private WebElement proceedToCheckoutButton;

    public ProductPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void waitOnProceedToCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PROCCEED_TO_CHECKOUT_BUTTON_XPATH)));
    }

    public void setSelectSizeDropDown(String sizeOption) {
        Select sizeSelector = new Select(selectSizeDropDown);
        sizeSelector.selectByValue(sizeOption);
    }

    public void setColorPicker(int colorOption) {
        WebElement colorSelection;
        String colorOptions;
        colorOptions = String.valueOf(colorOption);
        String colorXpath
                = "/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[2]/div/ul/li["
                + colorOptions + "]/a";

        try {
            colorSelection = driver.findElement(By.xpath(colorXpath));
            if (colorSelection.isDisplayed()) {
                colorSelection.click();
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
