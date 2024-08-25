package rest_api;

import environment.ApiEnvironment;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import rest_api.pojo.BasePojo;

import static io.restassured.RestAssured.given;

public class BaseRestAssuredConfig {

    //protected static final String API_BASE_URL = ApiEnvironment.getURL();
    protected static final ContentType JSON = ContentType.JSON;

    public static void init() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setConfig(createTimeoutConfig())
                .setPort(ApiEnvironment.getPort())
                .setContentType(JSON)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    private static RestAssuredConfig createTimeoutConfig(){
        return RestAssured.config()
                .httpClient(
                        HttpClientConfig.httpClientConfig()
                                .setParam("http.connection.timeout", ApiEnvironment.getRequestTimeout())
                                .setParam("http.socket.timeout", ApiEnvironment.getRequestTimeout()));
    }

    public static Response sendPostRequestAndGetResponse(BasePojo requestPojo, String uri, int statusCode) {
        RequestSpecification requestSpecification = given()
                .config(createTimeoutConfig())
                .basePath(uri);
        //        .cookies(cookies);

        ResponseSpecification respSpec = new ResponseSpecBuilder().expectStatusCode(statusCode).build();

        if (requestPojo != null)
            requestSpecification.body(requestPojo);

        requestSpecification.then().spec(respSpec);

        Response response = requestSpecification.post();

        return response;
    }

    public static Response sendGetRequest(String uri) {
        RequestSpecification requestSpecification = given()
                .config(createTimeoutConfig());

        Response response = requestSpecification
                .get(uri)
                .then()
                .extract()
                .response();
        return response;
    }

    public static Response sendStringAsEndPoint(String word) {
        return sendGetRequest(String.format("/%s", word));
    }
}
