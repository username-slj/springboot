package com.example.springboot.springboot.common;


import net.sf.cglib.beans.BeanCopier;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean工具类
 *
 * @author iybwb-shaolianjie
 */
public class CommonBeanUtils implements Serializable {
    private static final long serialVersionUID = -3767477994203241878L;

    private static Map<String, BeanCopier> map = new HashMap<>();

    /**
     * 对象复制
     *
     * @param obj1   被复制对象，为空会抛出异常
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
