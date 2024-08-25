package api.casumo_tests;

import api.BaseApiTest;
import api.RetryAnalyzer;
import helpers.StringHelper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SpacesTest extends BaseApiTest {

    private final String space = " ";
    private final String spaceLatinSpace = STR." \{StringHelper.generateRandomWord(StringHelper.allLatinAlphabet)} ";
    private final String latinSpaceLatin = STR."\{StringHelper.generateRandomWord(StringHelper.allLatinAlphabet)} \{StringHelper.generateRandomWord(StringHelper.allLatinAlphabet)}";
    private final String spaceLatinVowelsSpaceLatinVowels = STR." \{StringHelper.generateRandomWord(StringHelper.allLowerCaseLatinVowels)} \{StringHelper.generateRandomWord(StringHelper.allLowerCaseLatinVowels)}";
    private final String latinSpaceSpaceNumber = STR."\{StringHelper.generateRandomWord(StringHelper.allLatinAlphabet)}  \{StringHelper.generateRandomWord(StringHelper.allNumbers)}";
    private final String onlySpaces = StringHelper.generateRandomWord("  ");
    private final String allLatinConsonantsSpaces = StringHelper.generateRandomWord(StringHelper.allLatinConsonants, onlySpaces);

    @DataProvider(name = "dataProvider")
    public String[] wordDataProvider() {
        return new String[] {
                space,
                spaceLatinSpace,
                latinSpaceLatin,
                spaceLatinVowelsSpaceLatinVowels,
                latinSpaceSpaceNumber,
                onlySpaces,
                allLatinConsonantsSpaces
        };
    }
    @Test(testName = "Test spaces", dataProvider = "dataProvider", retryAnalyzer = RetryAnalyzer.class)
    public void mainTest(String inputString) {
        sendStringAndVerifyVowelTrimmed(inputString);
    }
}
