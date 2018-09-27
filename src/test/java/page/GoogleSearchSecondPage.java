package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GoogleSearchSecondPage extends GoogleBasePage{

    @FindBy(xpath = "//div[@class = 'srg']")
    private WebElement resultStats;

    @FindBy(xpath = "//div[@class = 'srg']/div[@class='g']")
    private List<WebElement> searchResults;

    public GoogleSearchSecondPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementVisible(resultStats, 20);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().contains("Selenium")
                &&getCurrentTitle().contains("Selenium");
    }

    public int getSearchResultsNumber() {
        return searchResults.size();
    }
    public List<String> getSearchResultList() {
        List<String>searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", searchResult);
            searchResultList.add(searchResult.getText());
        }
        return searchResultList;
    }

}
