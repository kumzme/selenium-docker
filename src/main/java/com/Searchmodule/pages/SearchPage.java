package com.Searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id="search_form_input_homepage")
    private WebElement searchBox;
    @FindBy(id = "search_button_homepage")
    private WebElement serachBtn;
    @FindBy(xpath= "//a[contains(text(),'Videos')]")
    private WebElement videoLinkItem;
    @FindBy(className =  "tile--vid")
    private List<WebElement> allvideos;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver, this);
         }
     public void gotToUrl(){
        this.driver.get("https://duckduckgo.com/");
     }
     public void doSearch(String serachItem){
        this.wait.until(ExpectedConditions.visibilityOf(this.searchBox));
        searchBox.sendKeys(serachItem);
        this.serachBtn.click();
     }
     public  void goToVideo(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videoLinkItem));
        this.videoLinkItem.click();
         }

      public int getResult(){
        By by = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(this.allvideos.size());
        return this.allvideos.size();
      }

}
