package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleStartPage extends GoogleBasePage {

    public GoogleStartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@name='btnK']")
    private WebElement searchButton;

    public GoogleSearchPage enterSearchTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.TAB);
        searchButton.click();

        return new GoogleSearchPage(driver);
    }

    public boolean isPageLoaded() {
        return getCurrentUrl().equals("https://www.google.com/")
                &&getCurrentTitle().equals("Google")
                && searchButton.isDisplayed();

    }
}