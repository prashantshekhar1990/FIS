package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EbayLandingPage {
    WebDriver driver;
    @FindBy(xpath = "//input[@aria-label='Search for anything']")
    private WebElement searchInput;

    public EbayLandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement searchButton;

    public void searchItem(String itemName) {
        searchInput.sendKeys(itemName);
        searchButton.click();
    }

    public void navigation(String url) {
        driver.get(url);
    }
}
