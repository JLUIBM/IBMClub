package cn.jluibm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyec on 2017/5/21.
 */
public class CheckTools {

    private static String PATTERN_EMAIL = "^([\\w-_]+(?:\\.[\\w-_]+)*)@((?:[a-z0-9]+(?:-[a-zA-Z0-9]+)*)+\\.[a-z]{2,6})$";

    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

}
