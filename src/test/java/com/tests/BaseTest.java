package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() throws Exception {
        //Browser => chrome/firefox
        //HUB_HOSt => localhost/10.0.0.13/hostname

        String host = "localhost";
        DesiredCapabilities dc;

        if (System.getProperty("Browser") != null && (System.getProperty("Browser").equalsIgnoreCase("firefox")))
            dc = DesiredCapabilities.firefox();
        else
            dc = DesiredCapabilities.chrome();

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUS_HOST");
        }

        dc.setAcceptInsecureCerts(true);
        ChromeOptions aa = new ChromeOptions();
//        aa.addArguments("--whitelisted-ips=");
//        dc.setCapability(ChromeOptions.CAPABILITY, aa);

        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);
    }

    @AfterTest
    public void quitDriver() {
        driver.quit();
    }
}
