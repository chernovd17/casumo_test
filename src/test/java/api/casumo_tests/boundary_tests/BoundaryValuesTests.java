package api.casumo_tests.boundary_tests;

import api.BaseApiTest;
import api.RetryAnalyzer;
import helpers.StringHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoundaryValuesTests extends BaseApiTest {

    private final String oneLowerCaseVowel = StringHelper.getRandomSymbolFrom(StringHelper.allLowerCaseLatinVowels);
    private final String oneUpperCaseVowel =  StringHelper.getRandomSymbolFrom(StringHelper.allUpperCaseLatinVowels);

    private final String oneLowerCaseConsonants = StringHelper.getRandomSymbolFrom(StringHelper.allLowerCaseLatinConsonants);
    private final String oneUpperCaseConsonants = StringHelper.getRandomSymbolFrom(StringHelper.allUpperCaseLatinConsonants);

    private final String oneNumber = StringHelper.getRandomSymbolFrom(StringHelper.allNumbers);
    private final String oneSpecialSymbol = StringHelper.getRandomSymbolFrom(StringHelper.allSpecialSymbols);
    private final String vowelAndNumber = oneLowerCaseVowel + oneNumber;
    private final String consonantAndNumber = oneLowerCaseConsonants + oneNumber;
    private final String vowelAndSpecialSymbol = oneLowerCaseVowel + oneSpecialSymbol;
    private final String consonantAndSpecialSymbol = oneLowerCaseConsonants + oneSpecialSymbol;

    private final String vowelAndConsonantLowerCase = oneLowerCaseVowel + oneLowerCaseConsonants;
    private final String consonantAndVowelLowerCase = oneLowerCaseConsonants + oneLowerCaseVowel;

    private final String vowelAndConsonantUpperCase = oneUpperCaseVowel + oneUpperCaseConsonants;
    private final String consonantAndVowelUpperCase = oneUpperCaseConsonants + oneUpperCaseVowel;

    private final String maxLowerCaseConsonants = StringHelper.generateRandomStringWithMaxLength(StringHelper.allLowerCaseLatinConsonants);
    private final String maxLowerCaseVowels = StringHelper.generateRandomStringWithMaxLength(StringHelper.allLowerCaseLatinConsonants);
    private final String maxAllMix = StringHelper.generateRandomStringWithMaxLength(StringHelper.allPossibleSymbols);

    private final String cyrillicConsonantsAndLatinVowels = StringHelper.generateRandomWord(
            StringHelper.allLowerCaseCyrillicConsonants,StringHelper.allLowerCaseLatinVowels);

    private final String latinConsonantsAndCyrillicVowels = StringHelper.generateRandomWord(
            StringHelper.allLowerCaseCyrillicVowels,StringHelper.allLowerCaseLatinConsonants);

    @DataProvider(name = "dataProvider")
    public String[] wordDataProvider() {
        return new String[] {
                oneLowerCaseVowel,
                oneUpperCaseVowel,

                oneLowerCaseConsonants,
                oneUpperCaseConsonants,

                oneNumber,
                oneSpecialSymbol,

                vowelAndNumber,
                vowelAndSpecialSymbol,
                vowelAndConsonantLowerCase,
                vowelAndConsonantUpperCase,

                consonantAndNumber,
                consonantAndSpecialSymbol,
                consonantAndVowelLowerCase,
                consonantAndVowelUpperCase,

                maxLowerCaseVowels,
                maxLowerCaseConsonants,
                maxAllMix,

                cyrillicConsonantsAndLatinVowels,
                latinConsonantsAndCyrillicVowels
        };
    }
    @Test(testName = "Positive Test for Boundary Values", description = "Verify boundary values, which should return no errors",
            dataProvider = "dataProvider", retryAnalyzer = RetryAnalyzer.class, threadPoolSize = 10)
    public void mainTest(String inputString) {
        sendStringAndVerifyVowelTrimmed(inputString);
    }
}
