package core.ui;

import core.api.TestContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Browser {
    private final static String driverPath = System.getProperty("user.dir") + "/src/main/resources/chromeDriver.exe";

    public Browser() throws IOException {
        initializeBrowser();
    }


    private TestContext getTestContext() throws IOException {
        return new TestContext();
    }

    private WebDriver driver;


    private void initializeBrowser() throws IOException {
        setLocalChromeDriver();
        driver = new ChromeDriver();
    }

    private void setLocalChromeDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
