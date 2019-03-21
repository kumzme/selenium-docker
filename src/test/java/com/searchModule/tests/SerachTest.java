package com.searchModule.tests;

import com.Searchmodule.pages.SearchPage;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SerachTest extends BaseTest {
   @Test
    @Parameters({"searchKeyword"})
    public void serach(String searchKeyword){
        SearchPage searchPage = new SearchPage(driver);
        searchPage.gotToUrl();
        searchPage.doSearch(searchKeyword);
        searchPage.goToVideo();
        int getlist = searchPage.getResult();
        Assert.assertTrue(getlist >0);
    }
}
