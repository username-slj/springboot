package com.example.springboot.springboot.models.sort;

import java.util.Arrays;

/**
 * @author shaolianjie
 * 冒泡排序
 */
public class Bubbling {
    public static void main(String[] args) {
        /**
         * 入参：1, 3, 5, 6, 2, 4
         * 结果：1, 2, 3, 4, 5, 6
         */
        int[] a = {1, 3, 5, 6, 2, 4};
        method(a);
    }

    public static void method(int[] param) {
        for (int i = 1; i <= param.length - 1; i++) {
            for (int j = 0; j < param.length - i; j++) {
                if (param[j] > param[j + 1]) {
                    int t = param[j];
                    param[j] = param[j + 1];
                    param[j + 1] = t;
                }
            }
            System.out.println("第" + i + "轮的结果:" + Arrays.toString(param));
        }
        System.out.println("最后的结果:" + Arrays.toString(param));
    }
}
