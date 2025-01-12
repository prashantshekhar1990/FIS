package core.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RestSpecBuilder {
    private static final String BASE_URI = "http://api.coindesk.com";
    private static final String DEFAULT_CONTENT_TYPE = "application/json";
    public static RequestSpecification getRequestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI) // Set the base URI
                .setContentType(DEFAULT_CONTENT_TYPE) // Set default content type
                .addHeader("Accept", "application/json") // Add headers (optional)
                .build(); // Build the specification
    }
}
