package steps;

import core.api.APICalls;
import core.api.TestContext;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import com.jayway.jsonpath.JsonPath;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;


public class APISteps {
    private Response response;
    private final TestContext _testContext;

    public APISteps(TestContext testContext) {
        _testContext = testContext;

    }

    @And("^user make a get call to \"(.*)\"$")
    public void getCall(String endpoint) {
        Response response = APICalls.testGetCall(endpoint);
        _testContext.setJsonResponse( response);
    }

    @And("^user verify \"(.*)\" has \"(.*)\" objects$")
    public void testObjects(String node, String objectCount) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String response = APICalls.convertResponseToJson(_testContext.getJsonResponse());
        Map<String, Object> jsonData = objectMapper.readValue(response, HashMap.class);

        Map<String, Object> bpiNode = (Map<String, Object>) jsonData.get(node);

        Assert.assertTrue(bpiNode.size() == Integer.valueOf(objectCount));
    }

    @And("^user verify value is \"(.*)\" at json path \"(.*)\"$")
    public void verifyJsonPath(String expected, String jsonPath) {
        String responseStored = APICalls.convertResponseToJson(_testContext.getJsonResponse());
        String value = JsonPath.read(responseStored, jsonPath);
        Assert.assertTrue(value.equalsIgnoreCase(expected));

    }
}
