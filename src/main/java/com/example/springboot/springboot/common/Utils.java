package com.example.springboot.springboot.common;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String DATE_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDateToString(Date date, String format) {
        if (date != null && !StringUtils.isEmpty(format)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        }
        return "";
    }
}
