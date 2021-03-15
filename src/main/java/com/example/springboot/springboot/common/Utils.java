package com.example.springboot.springboot.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String DATE_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转字符串
     *
     * @param date   日期
     * @param format 格式
     * @return 字符串
     */
    public static String formatDateToString(Date date, String format) {
        if (date != null && !StringUtils.isEmpty(format)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        }
        return "";
    }

    /**
     * 对象转json
     *
     * @param object 对象
     * @return json字符串
     */
    public static String objectToJson(Object object) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat(DATE_LONG_FORMAT).create();
        if (object == null) {
            return gson.toJson(JsonNull.INSTANCE);
        }
        return gson.toJson(object);
    }

}
