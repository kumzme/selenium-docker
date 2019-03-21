package com.newtour.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(name = "firstName")
    private WebElement FirstNameTxt;
    @FindBy(name = "lastName")
    private WebElement LastNameTxt;
    @FindBy(name= "email")
    private WebElement userNameTxt;
    @FindBy(name= "password")
    private WebElement passwordTxt;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordTxt;
    @FindBy(name = "register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver,this);

    }
    public  void goTo(){
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(FirstNameTxt));
        this.wait.until(ExpectedConditions.visibilityOf(LastNameTxt));

    }
    public void enterUserdetails(String firstName, String lastName){

        this.FirstNameTxt.sendKeys(firstName);
        this.LastNameTxt.sendKeys(lastName);
    }
    public void enterUserCredentials(String userName, String password){
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }
    public void clickBtn(){
        this.submitBtn.click();
    }
}
