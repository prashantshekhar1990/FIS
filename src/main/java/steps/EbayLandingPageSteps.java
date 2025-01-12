package steps;

import core.api.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import managers.PageObjectManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EbayLandingPage;
import pages.ProducListPage;
import pages.ProductDetailsPage;

public class EbayLandingPageSteps {
    private final static String driverPath = System.getProperty("user.dir") + "/src/main/resources/chromeDriver.exe";
    PageObjectManager pageObjectManager;
    WebDriver driver;
    TestContext testContext;
    EbayLandingPage homepage;
    ProducListPage producListPage;
    ProductDetailsPage productDetailsPage;

    public EbayLandingPageSteps(TestContext context) {
        testContext = context;
        homepage = testContext.getPageObjectManager().getHomePage();
        productDetailsPage = testContext.getPageObjectManager().getProductDetailsPage();
        producListPage = testContext.getPageObjectManager().getProducListPage();
    }


    @Given("^user navigate to \"(.*)\"$")
    public void navigation(String url) {
        homepage.navigation(url);
    }

    @And("^user search \"(.*)\" on search box on \"Ebay\" home page$")
    public void searchProductOnPage(String productName) {
        homepage.searchItem(productName);
    }

    @And("^user clicks on first product on \"Product List\" page$")
    public void clickFirstItem() {
        producListPage.clickOnFirstItem();
    }

    @And("^user verify product count is \"(.*)\" on \"Prodcut Details\" page$")
    public void verifyItemInCart(String count) {
        productDetailsPage.assertValueInCart(count);
     }

     @And("^user click on \"Add to Cart\" button$")
    public void userAddToCart(){
        productDetailsPage.clickAddToCart();
     }
//
//    @Given("user print {string} on console")
//    public void user_print_on_console(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        System.out.println(" first hit");
//    }
}
