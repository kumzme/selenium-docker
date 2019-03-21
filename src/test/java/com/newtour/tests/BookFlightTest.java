package com.newtour.tests;

import com.newtour.pages.*;
import com.tests.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {
    protected WebDriverWait wait;
    private String expectedPrice;
    private String noOfPassengers;

    @BeforeTest
    @Parameters({"noOfPassengers","expectedPrice"})
    public void setupParameters(String noOfPassenger,String expectedPrice){
       this.noOfPassengers = noOfPassenger;
       this.expectedPrice = expectedPrice;
    }

    @Test
    public void RegistrationPage(){
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterUserCredentials("first","seleniumdocker");
        registrationPage.enterUserdetails("selenium","docker");
        registrationPage.clickBtn();
    }
    @Test(dependsOnMethods = "RegistrationPage")
     public void RegistrationConfirmationPage() throws Exception {

        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goTofindFlightPage();
    }
    @Test(dependsOnMethods = "RegistrationConfirmationPage" )
    public void FlightDetailsPage(){
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(noOfPassengers);
        flightDetailsPage.goTofindFlightsPage();
    }
    @Test(dependsOnMethods = "FlightDetailsPage" )
    public void FindFlightPage(){
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlight();
        findFlightPage.goToFlightConfirmationPage();
    }
    @Test(dependsOnMethods = "FindFlightPage" )
    public void FlightConfirmationPage(){
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
         String actualPrice = flightConfirmationPage.getPriceConfirmation();
        //Assert.assertEquals(expectedPrice,actualPrice);
    }

}

