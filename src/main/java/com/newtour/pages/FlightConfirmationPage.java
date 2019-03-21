package com.newtour.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//font[contains(text(), 'Confirmation')]")
    private WebElement flightconfMess;
    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;
   @FindBy(linkText = "SIGN-OFF")
   private WebElement signOff;
    public FlightConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public String getPriceConfirmation(){
        this.wait.until(ExpectedConditions.visibilityOf(flightconfMess));
        System.out.println(this.flightconfMess.getText());
        System.out.println(this.prices.get(0).getText());
        System.out.println(this.prices.get(1).getText());
        String price = this.prices.get(1).getText();
        this.signOff.click();
        return price;
      }

}
