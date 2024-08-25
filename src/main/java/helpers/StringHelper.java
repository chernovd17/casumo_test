package helpers;

import java.util.Random;


public class StringHelper {

    public static final int minWordLength = 3;
    public static final int maxWordLength = 66;
    private static final int maxLength = 8000;

    public static final String allLowerCaseLatinVowels = "aeiou";
    public static final String allUpperCaseLatinVowels = "AEIOU";
    public static final String allLatinVowels = allLowerCaseLatinVowels + allUpperCaseLatinVowels;

    public static final String allLowerCaseLatinConsonants = "bcdfghjklmnpqrstvwxyz";
    public static final String allUpperCaseLatinConsonants = "BCDFGHJKLMNPQRSTVWXYZ";
    public static final String allLatinConsonants = allLowerCaseLatinConsonants + allUpperCaseLatinConsonants;

    public static final String lowerLatinAlphabet = "abcdefghijklmnopqrstuvwxyz";
    public static final String upperLatinAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String allLatinAlphabet = lowerLatinAlphabet + upperLatinAlphabet;

    public static final String allSpecialSymbols = "!@$&#*()_+-=[]}%|;':,.<>?~";//without "/", "{"
    public static final String allNumbers = "1234567890";

    public static final String allPossibleSymbols = allLatinAlphabet + allSpecialSymbols + allNumbers;

    public static final String allLowerCaseCyrillicVowels = "аеёоыиyэюя";
    public static final String allUpperCaseCyrillicVowels = "АЕЁОЫИYЭЮЯ";
    public static final String allCyrillicVowels = allLowerCaseCyrillicVowels + allUpperCaseCyrillicVowels;

    public static final String allLowerCaseCyrillicConsonants = "бвгджзйклмнпрстфхцчшщъь";
    public static final String allUpperCaseCyrillicConsonants = "БВГДЖЗЙКЛМНПРСТФХЦЧШЩЪЬ";
    public static final String allCyrillicConsonants = allLowerCaseCyrillicConsonants + allUpperCaseCyrillicConsonants;

    public static final String allLowerCaseCyrillicLetters = allLowerCaseCyrillicVowels + allLowerCaseCyrillicConsonants;
    public static final String allUpperCaseCyrillicLetters = allUpperCaseCyrillicVowels + allUpperCaseCyrillicConsonants;
    public static final String allCyrillicLetters = allLowerCaseCyrillicLetters + allUpperCaseCyrillicLetters;

    public static final String allDiacriticsVowels = "àèòüỳȉȁôēỵǎÖÜΌÂĂÅĄÀÁÄ";
    public static final String allDiacriticsConsonants = "љçğşčćšśžżźçñ";

    public static String getAllVowels() {
        return allLatinVowels + allCyrillicVowels + allDiacriticsVowels;
    }

    public static String getAllLatinConsonants() {
        return allLowerCaseLatinConsonants + allUpperCaseLatinConsonants + allCyrillicVowels;
    }

    public static String getRandomSymbolFrom(String str) {
        return STR."\{str.charAt((int) (Math.random() * str.length()))}";
    }

    private static String generateRandomStringWithRangeFrom(String str, int minLength, int maxLength) {
        Random random = new Random();
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++)
            sb.append(str.charAt(random.nextInt(str.length())));


        return sb.toString();
    }

    public static String generateRandomStringWithMaxLength(String str){
        return generateRandomStringWithRangeFrom(str, maxLength, maxLength);
    }

    public static String generateRandomWord(String... str){
        StringBuilder result = new StringBuilder();

        for(String s : str) {
            result.append(s);
        }
        return generateRandomStringWithRangeFrom(result.toString(), minWordLength, maxWordLength);
    }


}