package cn.jluibm.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hyec on 2017/5/21.
 */
public class FormTools {

    private static String PATTERN_EMAIL = "^([\\w-_]+(?:\\.[\\w-_]+)*)@((?:[a-z0-9]+(?:-[a-zA-Z0-9]+)*)+\\.[a-z]{2,6})$";

    /**
     * 检测文本是否为邮箱地址
     * @param text 文本
     * @return 是否为邮箱
     */
    public static boolean checkEmail(String text) {
        if (text == null)
            return false;
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    /**
     * 检测文本有效性
     * @param text 文本
     * @return 有效性
     */
    public static boolean checkText(String text) {
        return checkText(text, -1, -1);
    }

    /**
     * 检测文本有效性和长度
     * @param text 文本
     * @param min 最小长度
     * @return 有效性
     */
    public static boolean checkText(String text, int min) {
        return checkText(text, min, -1);
    }


    /**
     * 检测文本有效性和长度
     * @param text 文本
     * @param min 最小长度
     * @param max 最大长度
     * @return 有效性
     */
    public static boolean checkText(String text, int min, int max) {
        if (text == null)
            return false;

        int length = text.length();

        if (min > 0 && length < min)
            return false;
        if (max > 0 && length > max)
            return false;

        return true;
    }


}
