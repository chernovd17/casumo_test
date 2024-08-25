package api;

import helpers.StringHelper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import rest_api.BaseRestAssuredConfig;

public class BaseApiTest {

    @BeforeSuite
    public void initRestAssured(){
        BaseRestAssuredConfig.init();
    }

    protected String sendRequestAndGetResponseValue(String text){
        Response response = BaseRestAssuredConfig.sendStringAsEndPoint(text);

        return response.getBody().asString();
    }

    protected String removeAllVowels(String str) {
        return str.replaceAll(String.format("[%s]", StringHelper.getAllVowels()), "");
    }

    protected void assertEquals(String actual, String expected) {
        System.out.println(String.format("Verify actual value '%s' as expected '%s'", actual, expected));
        Assert.assertEquals(actual, expected, String.format("Verify actual value '%s' as expected '%s'", actual, expected));
    }

    protected void sendStringAndVerifyVowelTrimmed(String word) {
        String response = sendRequestAndGetResponseValue(word);
        assertEquals(response, removeAllVowels(word));
    }

    protected String getRandomSymbol(String possibleValues){
        return STR."\{possibleValues.charAt((int) (Math.random() * possibleValues.length()))}";
    }

}
