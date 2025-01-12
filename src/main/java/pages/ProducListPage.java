package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.ArrayList;
import java.util.Set;

public class ProducListPage {
    WebDriver driver;

    public ProducListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//ul[contains(@class,'srp-results srp-list clearfix')]//li)[1]//child::img")
    private WebElement firstSearchItem;

    public void clickOnFirstItem() {
        firstSearchItem.click();
        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);
        driver.switchTo().window(tabs.get(1));
    }
}
