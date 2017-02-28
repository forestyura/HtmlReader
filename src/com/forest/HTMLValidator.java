package com.forest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuriy Vlasiuk on 28.02.2017.
 */
public class HTMLValidator {
    public static final String HTML_PATTERN = "^<!(doctype|DOCTYPE) (html|HTML).+</html>$";

    /**
     * Checking the validity of the pattern
     * @param html The text must be checked
     * @return True if valid, false if invalid
     */
    public static boolean validate (String html) {
        Pattern pattern = Pattern.compile(HTML_PATTERN);
        Matcher matcher = pattern.matcher(html);
        return matcher.matches();
    }
}
