package com.example.springboot.springboot.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonNull;
import net.sf.cglib.beans.BeanCopier;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    public static final String DATE_LONG_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static Map<String, BeanCopier> map = new HashMap<>();

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

    public static Date formatStringToDate(String date, String format){
        if(StringUtils.isEmpty(date)){
            return null;
        }
        SimpleDateFormat sdf=new SimpleDateFormat(Utils.DATE_LONG_FORMAT);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
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

    /**
     * 对象复制
     * @param obj1 被复制对象，为空会抛出异常
     * @param classz 复制类型
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object obj1, Class<T> classz) {
        if (obj1 == null || classz == null) {
            throw new IllegalArgumentException("复制对象或者被复制类型为空!");
        }
        T obj2 = null;
        try {
            obj2 = classz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        String name = getClassName(obj1.getClass(), classz);
        BeanCopier beanCopier;
        if (map.containsKey(name)) {
            beanCopier = map.get(name);
        } else {
            beanCopier = BeanCopier.create(obj1.getClass(), classz, false);
            map.put(name, beanCopier);
        }
        beanCopier.copy(obj1, obj2, null);
        return obj2;
    }

    private static String getClassName(Class<?> class1, Class<?> class2) {
        return class1.getName() + class2.getName();
    }
}
