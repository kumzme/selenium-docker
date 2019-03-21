package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),' sign-in ')]")
    private WebElement signInText;
    @FindBy(xpath = "//a[contains(text(),'Flights')]")
    private WebElement flightLink;

    public RegistrationConfirmationPage(WebDriver driver){
        this.driver= driver;
        this.wait = new WebDriverWait(driver,60);
        PageFactory.initElements(driver,this);
    }
    public void goTofindFlightPage() throws Exception{
        this.wait.until(ExpectedConditions.visibilityOf(signInText));
        this.wait.until(ExpectedConditions.elementToBeClickable(flightLink));
        flightLink.click();
    }
}
