package api.casumo_tests.boundary_tests;

import api.BaseApiTest;
import helpers.StringHelper;

import org.apache.http.NoHttpResponseException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeBoundaryTests extends BaseApiTest {

    private final String maxInputString = StringHelper.generateRandomStringWithMaxLength(StringHelper.allLatinAlphabet);

    private final String maxInputStringWithVowel = maxInputString + StringHelper.getRandomSymbolFrom(StringHelper.allLowerCaseLatinVowels);
    private final String maxInputStringWithConsonant = maxInputString + StringHelper.getRandomSymbolFrom(StringHelper.allLowerCaseLatinConsonants);


    @DataProvider(name = "dataProvider")
    public String[] wordDataProvider() {
        return new String[] {
                maxInputStringWithVowel,
                maxInputStringWithConsonant
        };
    }

    @Test(testName = "Verification of server errors for length max+1 input", dataProvider = "dataProvider")
    public void mainTest(String inputString) {
        try {
            sendRequestAndGetResponseValue(inputString);
            Assert.assertTrue(false, "Expected error not found");
        } catch (Exception e){
            if (!(e instanceof NoHttpResponseException))
                Assert.fail(STR."Error: \{e.getMessage()}");
            else
                Assert.assertTrue(true, "Expected error for input string as expected");
        }
    }
}
