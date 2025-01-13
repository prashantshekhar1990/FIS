package core.api;

import io.restassured.response.Response;
import managers.DriverFactory;
import managers.PageObjectManager;

public class TestContext {
    private DriverFactory driverFactory;
    private PageObjectManager pageObjectManager;
    private Response jsonResponse;

    public TestContext() {
        driverFactory = new DriverFactory();
        pageObjectManager = new PageObjectManager(driverFactory.getDriver());
    }

    public io.restassured.response.Response getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(Response jsonResponse) {
        this.jsonResponse = jsonResponse;
    }

    public DriverFactory getWebDriverManager() {
        return driverFactory;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

}