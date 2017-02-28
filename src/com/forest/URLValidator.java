package com.forest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Yuriy Vlasiuk on 28.02.2017.
 */
public class URLValidator {
    public static final String URL_PATTERN = "^(https?:\\/\\/)([\\w\\.]+)\\.([a-z]{2,6}\\.?)(\\/[\\w\\.]*)*\\/?$";

    /**
     * Checking the validity of the pattern
     * @param url The url must be checked
     * @return True if valid, false if invalid
     */
    public static boolean validate (String url) {
        Pattern pattern = Pattern.compile(URL_PATTERN);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
