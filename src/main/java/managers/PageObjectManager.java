package managers;

import org.openqa.selenium.WebDriver;
import pages.EbayLandingPage;
import pages.ProducListPage;
import pages.ProductDetailsPage;

public class PageObjectManager {
    private WebDriver driver;
    private EbayLandingPage ebayLandingPage;
    private ProducListPage producListPage;
    private ProductDetailsPage productDetailsPage;

    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }

    public EbayLandingPage getHomePage() {
        return (ebayLandingPage == null) ? ebayLandingPage = new EbayLandingPage(driver) : ebayLandingPage;
    }

    public ProducListPage getProducListPage() {
        return (producListPage == null) ? producListPage = new ProducListPage(driver) : producListPage;
    }

    public ProductDetailsPage getProductDetailsPage() {
        return (productDetailsPage == null) ? productDetailsPage = new ProductDetailsPage(driver) : productDetailsPage;
    }
}
