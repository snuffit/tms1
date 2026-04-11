package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Pstyga Stas
 * @created 11.04.2026
 */
public class RegExHelper {

    private static final String REGEX_ABBREVIATION = "\\b[A-Z]{2,6}\\b",
            REGEX_EMAIL = "\\b[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\b",
            REGEX_DOC_NUM = "\\b\\d{4}-\\d{4}-\\d{2}\\b",
            REGEX_PHONE_NUM = "\\+\\(\\d{2}\\)\\d{7}";


    public static void findAbbreviationInStr(String str) {
        Pattern pattern = Pattern.compile(REGEX_ABBREVIATION);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            System.out.println(matcher.group() + " ");
        }
    }

    public static void findPersonalInfoInStr(String str) {
        String email = getStringByRegEx(REGEX_EMAIL, str);
        String docNum = getStringByRegEx(REGEX_DOC_NUM, str);
        String phoneNum = getStringByRegEx(REGEX_PHONE_NUM, str);
        System.out.println("Email: " + email +
                "\n" + "Phone number: " + phoneNum +
                "\n" + "Doc number: " + docNum);
    }

    private static String getStringByRegEx(String regEx, String str) {
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
