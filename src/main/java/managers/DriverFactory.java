package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
    private WebDriver driver;
    private final static String driverPath = System.getProperty("user.dir") + "/src/main/resources/chromeDriver.exe";

    public WebDriver getDriver() {
        if (driver == null) {
            driver = initiateLocalDriver();
        }
        return driver;
    }

    public WebDriver initiateLocalDriver() {
        System.setProperty("webdriver.chrome.driver", driverPath);
        return new ChromeDriver();
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }
}
