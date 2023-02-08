package com.ade.demo.server.utils;

import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 判断字符串是否是数字
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str.length() > 9) return false;
        Pattern pattern = Pattern.compile("^(0|[0-9]*|-[0-9]*)$");
        return pattern.matcher(str).matches();
    }

}
