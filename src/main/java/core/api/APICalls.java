package core.api;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICalls {
    static Response response;

    public static Response testGetCall(String url) {
        // Get the reusable RequestSpecification
        RequestSpecification requestSpec = RestSpecBuilder.getRequestSpecification();

//         Perform GET request
         response = (Response) RestAssured
                .given(requestSpec)
                .when()
                .get(url); // Add endpoint to the base URI
        System.out.println(response.prettyPrint());


        return response;
    }

    public static String convertResponseToJson(Response response) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String responseBody = response.getBody().asString();
            Object jsonObject = objectMapper.readValue(responseBody, Object.class);
            return objectMapper.writeValueAsString(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
