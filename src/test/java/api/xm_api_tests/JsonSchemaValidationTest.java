package api.xm_api_tests;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import rest_api.BaseRestAssuredConfig;

import java.io.File;

public class JsonSchemaValidationTest extends BaseXMTest {

    private static final String PEOPLE_END_POINT = "/people";
    @Test
    public void testAPIResponseSchema() {

        File schema = new File("src/main/resources/files/schema.json");
        Response response = BaseRestAssuredConfig.sendGetRequest(PEOPLE_END_POINT);
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));

    }
}
