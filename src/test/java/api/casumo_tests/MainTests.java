package api.casumo_tests;

import api.BaseApiTest;
import api.RetryAnalyzer;
import helpers.StringHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MainTests extends BaseApiTest {

    private final String lowerLatinConsonantWord = StringHelper.getRandomSymbolFrom(
            StringHelper.allLowerCaseLatinConsonants) + StringHelper.generateRandomWord(StringHelper.lowerLatinAlphabet);
    private final String lowerLatinVowelWord = StringHelper.getRandomSymbolFrom(StringHelper.allLowerCaseLatinConsonants) + StringHelper.generateRandomWord(StringHelper.lowerLatinAlphabet);
    private final String lowerVowelLatinWithNumbers = StringHelper.generateRandomWord(StringHelper.allLowerCaseLatinVowels,StringHelper.allNumbers);
    private final String lowerVowelLatinWithSpecialSymbols = StringHelper.generateRandomWord(StringHelper.allLowerCaseLatinVowels,StringHelper.allSpecialSymbols);


    @DataProvider(name = "dataProvider")
    public String[] wordDataProvider() {
        return new String[] {
                lowerLatinConsonantWord,
                lowerLatinVowelWord,
                lowerVowelLatinWithNumbers,
                lowerVowelLatinWithSpecialSymbols
        };
    }
    @Test(testName = "Main Verification with lower case 'words'", dataProvider = "dataProvider", retryAnalyzer = RetryAnalyzer.class)
    public void mainTest(String inputString) {
        sendStringAndVerifyVowelTrimmed(inputString);
    }
}
