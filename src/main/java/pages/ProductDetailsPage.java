package pages;

 import org.junit.Assert;
 import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductDetailsPage {
    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    WebDriver driver;
    @FindBy(xpath = "//li[contains(.,'Add to cart')]//child::a")
    private WebElement addToCartButton;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']//child::i")
    private WebElement itemsInCartIcon;

    @FindBy(xpath = "")
    private WebElement productQuantityByProductName;

    public String getCartItemCount() {
        return itemsInCartIcon.getText();
    }

    public void clickAddToCart(){
        addToCartButton.click();
    }

    public void assertValueInCart(String itemCount) {
        Assert.assertTrue(getCartItemCount().equalsIgnoreCase(itemCount));
    }

}
