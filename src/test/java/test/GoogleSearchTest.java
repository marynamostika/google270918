package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.GoogleSearchPage;
import page.GoogleSearchSecondPage;


import java.util.List;

public class GoogleSearchTest extends GoogleBaseTest {

    @Test
    public void searchTest() {
        String searchTerm = "Selenium";
        Assert.assertTrue(googleStartPage.isPageLoaded());
        GoogleSearchPage googleSearchPage = googleStartPage.enterSearchTerm(searchTerm);
        Assert.assertTrue(googleSearchPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSearchPage.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page");

        List<String> searchResultList = googleSearchPage.getSearchResultList();

        for (String searchResult : searchResultList ) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+ searchTerm+" not found in:\n"+searchResult);
        }
        GoogleSearchSecondPage googleSearchSecondPage = googleSearchPage.goToSecondPage();
        Assert.assertTrue(googleSearchSecondPage.isPageLoaded(), "Search page is not loaded.");

        Assert.assertEquals(googleSearchSecondPage.getSearchResultsNumber(), 10,
                "Wrong number of searchResults on Search page");

        searchResultList = googleSearchSecondPage.getSearchResultList();

        for (String searchResult : searchResultList ) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "SearchTerm "+ searchTerm+" not found in:\n"+searchResult);
        }
    }
}
