package com.zone.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private WebDriver driver;

    private static String PAGE_URL="http://automationpractice.com/";

    @FindBy(id = "header_logo")
    private WebElement homePageHeaderLogo;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a")
    private WebElement womensHomePageTab;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[2]/div/div[1]/ul[1]/li[1]/div/div[1]/div/a[1]/img")
    private WebElement firstImageInQuickView;

    public HomePage(WebDriver driver){
        this.driver=driver;
        driver.get(PAGE_URL);
        //Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void clickWomensHomePageTab() {
        womensHomePageTab.click();
    }

    public void clickfirstImageInQuickView() {
        firstImageInQuickView.click();
    }
}
