package com.example.springboot.springboot.jdk8;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springboot.springboot.common.Utils;
import com.example.springboot.springboot.jdk8.entity.A;
import com.example.springboot.springboot.jdk8.entity.A2;
import com.example.springboot.springboot.jdk8.entity.B;
import com.example.springboot.springboot.jdk8.entity.ListsDTO;
import com.example.springboot.springboot.jdk8.entity.RiskUserRep;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.drools.core.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class Test {
    private static final String PHONE = "^1[3-9]\\d{9}$";
    private static final String ACCOUNT = "^([1-9]\\d*\\d*)$";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //->写法
//        test1();
        //无参应用::
//        test2();
        //arrays
//        test2();
        //i++先引用在计算，++i先计算在引用
//        test3();
        //== 和 equals
//        test04();
//        jdk8循环非空判断
//        test05();
//        jdk8的forEach不能使用break,continue, 可以使用return代替continue（return和continue是一样的效果）
//        test06();
//          字符串内存模型
//        test07();
//        BeanUtils.copyProperties:spirng包，copy会把空值的字段过滤
//        test08();
//        list(BO)转List(BO):硬编码
//        test09();
//        对象转json
//        test10();
//        @Slf4j
//        test11();
//        JSONObject---JSONArray
//        test12();
//        StringJoiner
//        test13();
//        switch 如果第一个条件没有break，第二个语句不会判断直接输出
//        test14();
//        CompletableFuture.supplyAsync:异步执行完main在可以执行
//        test15();
//        替换{name}
//        test16();
        //cglib copy
//        test18();
        //jsonArray转list
//        test21();
//        去除json不需要的字段
//        test23();
        //stream 常用方法
//        test24();
        //LocalDateTime
//        test25();
        //重复去除后获取最新日期一条
//        test26();
        //去除两个集合重复信息
//        test27();
        test28();
    }

    private static void test28() {



    }

    private static void test27() {
        List<String> data1 = new ArrayList<>();
        data1.add("1");
        data1.add("2");

        List<String> data2 = new ArrayList<>();
        data2.add("2");
        data2.add("1");
        data2.add("3");
        data2.add("4");
        data2.add("5");

        List<String> result = data2.stream()
                .filter(d1 ->
                        data1.stream()
                                .noneMatch(d2 -> Objects.equals(d1, d2))
                ).collect(Collectors.toList());
        System.out.println(result);


    }

    private static void test26() {
        ArrayList<RiskUserRep> list = new ArrayList<>();
        ArrayList<RiskUserRep> listResult = new ArrayList<>();

        RiskUserRep rep1 = new RiskUserRep();
        rep1.setAccountId(222L);
        rep1.setType("1");
        rep1.setGmtModified(Utils.formatStringToDate("2021-06-06 12:00:00", Utils.DATE_LONG_FORMAT));

        RiskUserRep rep2 = new RiskUserRep();
        rep2.setAccountId(222L);
        rep2.setType("2");
        rep2.setGmtModified(Utils.formatStringToDate("2021-06-16 12:00:00", Utils.DATE_LONG_FORMAT));
        list.add(rep1);
        list.add(rep2);
        log.info("list={}", JSON.toJSONString(list));

        Map<String, List<RiskUserRep>> groupMap = list.stream().collect(Collectors.groupingBy(a -> a.getAccountId().toString()));
        groupMap.forEach((a, b) -> {
            if (b.size() > 1) { //说明是重复数据,进行排序取出最新一个
                Optional<RiskUserRep> collect = b.stream().min((obj1, obj2) -> -DateUtil.compare(obj1.getGmtModified(), obj2.getGmtModified()));
//                Optional<RiskUserRep> collect = b.stream().sorted((obj1, obj2) -> -DateUtil.compare(obj1.getGmtModified(), obj2.getGmtModified())).findAny();
                listResult.add(collect.get());
            } else {
                listResult.add(b.get(0));
            }
        });
        log.info("listResult={}", JSON.toJSONString(listResult));
    }

    private static void test25() {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println("当前时间: " + currentTime);
        LocalDate date1 = currentTime.toLocalDate();
        System.out.println("date1: " + date1);
        Month month = currentTime.getMonth();
        int day = currentTime.getDayOfMonth();
        int seconds = currentTime.getSecond();
        System.out.println("月: " + month + ", 日: " + day + ", 秒: " + seconds);
        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println("date2: " + date2);
        // 12 december 2014
        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
        System.out.println("date3: " + date3);
        // 22 小时 15 分钟
        LocalTime date4 = LocalTime.of(22, 15);
        System.out.println("date4: " + date4);
        // 解析字符串
        LocalTime date5 = LocalTime.parse("20:15:30");
        System.out.println("date5: " + date5);

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + zonedDateTime);
        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);
        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

    private static void test24() {
        Random random = new Random();
        log.info("forEach 输出了10个随机数:");
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        log.info("map 获取对应的平方数={}", squaresList);

        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        int count = (int) strings.stream().filter(string -> string.isEmpty()).count();
        log.info("filter 获取空字符串的数量={}", count);

        log.info("forEach 输出了5个随机数:");
        random.ints().limit(5).forEach(System.out::println);

        log.info("sorted 方法对输出的 10 个随机数进行排序:");
        random.ints().limit(4).sorted().forEach(System.out::println);


        int count2 = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        log.info("parallel 并行获取空字符串的数量={}", count2);

    }

    private static void test23() {

        String str = "{\n" +
                "  \"policyList\": [\n" +
                "    {\n" +
                "      \"id\": \"001\",\n" +
                "      \"name\": \"zhangsan\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"002\",\n" +
                "      \"name\": \"lisi\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"003\",\n" +
                "      \"name\": \"wangwu\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        JSONObject jsonObject = test22(str, "policyList", "id");
        log.info("{}", jsonObject);
    }

    /**
     * 去除不需要的字段
     *
     * @param jsonStr   原始json
     * @param arrStr    去除的目标集合
     * @param removeStr 去除的字段名
     * @return 删除后的新json
     */
    private static JSONObject test22(String jsonStr, String arrStr, String removeStr) {
        JSONArray jsonArrayResult = new JSONArray();
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray jsonArray = (JSONArray) jsonObject.get(arrStr);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonResultData = (JSONObject) jsonArray.get(i);
            jsonResultData.remove(removeStr);
            jsonArrayResult.add(jsonResultData);
        }
        JSONObject jsonObjectResult = new JSONObject();
        jsonObjectResult.put(arrStr, jsonArrayResult);
        return jsonObjectResult;
    }

    private static void test21() {
        JSONArray jsonArray = new JSONArray();

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.put("gmtModified", "2021-05-27 00:00:01");
        jsonObject1.put("accountId", "001");
        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("gmtModified", "2021-05-27 00:00:02");
        jsonObject2.put("accountId", "001");
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("gmtModified", "2021-05-27 18:58:35");
        jsonObject3.put("accountId", "002");
        JSONObject jsonObject4 = new JSONObject();
        jsonObject4.put("gmtModified", "2021-05-27 18:58:30");
        jsonObject4.put("accountId", "003");
        JSONObject jsonObject5 = new JSONObject();
        jsonObject5.put("gmtModified", "2021-05-27 00:00:07");
        jsonObject5.put("accountId", "001");

        jsonArray.add(jsonObject1);
        jsonArray.add(jsonObject2);
        jsonArray.add(jsonObject3);
        jsonArray.add(jsonObject4);
        jsonArray.add(jsonObject5);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("message", "success");
        jsonObject.put("userList", jsonArray);

        log.info("json数组={}", JSON.toJSONString(jsonObject));


    }

    private static void test18() {
        A a = new A();
        a.setUniqueNo(001L);
        a.setStatus("001");
        a.setName("zhangsan");

        B b = Utils.copyObject(a, B.class);
        log.info("{}={}", b.getUniqueNo(), b.getStatus());

    }

    public static void test19() {
        log.info("这是test19方法");
        try {
            throw new NullPointerException();
        } catch (Exception e) {
            log.error("test19 err", e);
        }

    }

    public static void test20() {

        log.info("这是test20方法");


    }

    private static void test16() {
        StringBuilder sb = new StringBuilder();
        sb.append("sdfkslj建设路口{name}稍等");
        sb.append("sdfkslj建设路口{age}稍等");
        HashMap hashMap = new HashMap();
        hashMap.put("name", "zhangsan");
        hashMap.put("age", 20);
        String result = test17(sb.toString(), hashMap);
        log.info("result==={}", result);
    }

    public static String test17(String template, Map params) {
        StringBuffer sb = new StringBuffer();
        Matcher m = Pattern.compile("\\{\\w+\\}").matcher(template);
        while (m.find()) {
            String param = m.group();
            Object value = params.get(param.substring(1, param.length() - 1));
            m.appendReplacement(sb, value == null ? "" : value.toString());
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static void test15() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> {
            log.info("{} start1,time->{}", Thread.currentThread(), System.currentTimeMillis());
            if (true) {
                return "test15";
            } else {
                log.info("{} end1,time->{}", Thread.currentThread(), System.currentTimeMillis());
                return "======";
            }
        });

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            log.info("{} start3,time->{}", Thread.currentThread(), System.currentTimeMillis());
            if (true) {
                return "test16";
            } else {
                log.info("{} end3,time->{}", Thread.currentThread(), System.currentTimeMillis());
                return "======";
            }
        });
        log.info("run result->{}", completableFuture2.get());
        log.info("run result->{}", completableFuture1.get());
        log.info("main thread time->{}", System.currentTimeMillis());
    }

    private static void test14() {
        int i = 1;
        switch (i) {
            case 1:
            case 2:
                log.info("1,2");
                break;
            case 3:
                log.info("3");
                break;
            case 4:
                log.info("4");
                break;
            default:
                ;
        }
    }

    private static void test13() {
        StringJoiner stringJoiner = new StringJoiner(",");
        stringJoiner.add("aaa");
        stringJoiner.add("bbb");
        stringJoiner.add("ccc");
        //aaa,bbb,ccc
        log.info(stringJoiner.toString());
    }

    private static void test12() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("zhangsan", "张三");
        jsonObject.put("list", "李四");
        log.info(jsonObject.toString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        log.info("====={}", jsonArray.toString());
    }

    private static void test11() {
        ArrayList<A> arrayList = Lists.newArrayList();
        ListsDTO listsDTO = new ListsDTO();
        listsDTO.setA(arrayList);

        A a = new A();
        a.setName("aaa");
        a.setStatus("01");
        a.setUniqueNo(00L);
        arrayList.add(a);

        List<A> a1 = listsDTO.getA();
        for (A alist : a1) {
            log.info("info==={},{},{}", alist.getName(), alist.getStatus(), alist.getUniqueNo());
            log.debug("debug==={},{},{}", alist.getName(), alist.getStatus(), alist.getUniqueNo());
            log.error("error===={},{},{}", alist.getName(), alist.getStatus(), alist.getUniqueNo());
            log.warn("warn==={},{},{}", alist.getName(), alist.getStatus(), alist.getUniqueNo());
            log.trace("trace==={},{},{}", alist.getName(), alist.getStatus(), alist.getUniqueNo());
        }


    }

    private static void test10() {
        A a = new A();
        a.setUniqueNo(111L);
        a.setName("zhangsan");
        System.out.println(Utils.objectToJson(null));
    }

    private static void test09() {
        A a = new A();
        a.setName("lisi");
        a.setStatus("1");
        a.setUniqueNo(000002L);
        List<A> aList = new ArrayList<>();
        aList.add(a);

        A2 a2 = new A2();
        List<A2> a2List = new ArrayList<>();
        if (!CollectionUtils.isEmpty(aList)) {
            for (A aLists : aList) {
                BeanUtils.copyProperties(aLists, a2);
                a2List.add(a2);
            }
            System.out.println(a2List.get(0).getName() + "===" + a2List.get(0).getStatus() + "===" + a2List.get(0).getUniqueNo());
        }
    }

    private static void test08() {
        A a = new A();
        a.setName("zhangsan");
        a.setStatus("");
        a.setUniqueNo(0000001L);
        A2 a2 = new A2();
        BeanUtils.copyProperties(a, a2);
        System.out.println("===" + a2.getName() + "===" + a2.getStatus() + "===" + a2.getUniqueNo());

    }

    private static void test07() {
        //String是不可变的，“1”符号保存先判断常量池三方存在1，存在1就返回1的引用，不存在就保存后返回引用
        //new String("1") 首先在常量池中判断是否存在1存在就在堆中开辟一块内存存放1，返回堆内存引用
        //                不存在就在常量池中存放，在在堆内存中开辟一块内存存放返回堆内存的引用
        String a = "1";
        String b = "1";
        //引用类型+字符串属于运行时创建（a存放在常量池中，“”存放常量池中是两块所以引用地址不一样）
        System.out.println(a + "" == b);
        //字符串量直接保存在常量池中，“1”不是引用类型直接相加“”所以最后引用是一样
        System.out.println("1" + "" == b);
    }

    private static void test06() {
        List<String> list = new ArrayList<>();
        list.add("112");
        list.add("1133");
        list.add("115555");

        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(s -> {
            if (s.length() == 4) {
                return;
            }
            System.out.println(s);
        });
    }

    private static void test05() {
//        List<String> list = null;
        List<String> list = new ArrayList<>();
        list.add("11111");
        list.add("22222");
        list.add("33333");
        //普通写法
        if (!CollectionUtils.isEmpty(list)) {
            for (String str : list) {
                System.out.println(str);
                continue;
            }
        }
        //jdk8写法
        Optional.ofNullable(list).orElse(new ArrayList<>()).forEach(o -> {
            System.out.println(o);
        });
    }

    private static void test04() {
        /**
         * https://zhuanlan.zhihu.com/p/121603364
         * ==
         * 基本数据类型则直接比较其存储的 值是否相等，
         * 引用类型的变量则比较的是所指向的对象的地址是否相等
         *
         *equals 不重写和==相同作用
         *       重写后比较的是两个对象的值
         *       https://www.cnblogs.com/fangfuhai/p/5500065.html
         */
        int sums1 = 1;
        int sums2 = 1;
        String str1 = "str1";
        String str2 = "str1";
        String str3 = new String("str1");
        String str4 = new String("str1");
        String str5 = str1 + str4;
        String str6 = "str1str1";
        System.out.println(sums1 == sums2);//true
        System.out.println(str1 == str2);//true
        System.out.println(str3 == str4);//false 指向的地址不同
        System.out.println(str5 == str6);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str3.equals(str4));//true 地址不同值一样
        System.out.println(str1.equals(str4));//true 同上
        System.out.println(str1.equals(str4));//true
        System.out.println(str5.equals(str6));//true
    }

    private static void test3() {
        int i1 = 10;
        int i11 = i1++;
        int i2 = 10;
        int i22 = ++i2;
        System.out.println(i11);
        System.out.println(i22);
    }

    private static void test2() {
        String[] strarray = {"d", "b", "c", "a"};
        List<String> abcd = Arrays.asList(strarray);
        System.out.println("asList数组转list：");
        abcd.forEach(item -> {
            System.out.println(item);
        });

        Arrays.sort(strarray);
        System.out.print("sort排序：");
        for (int i = 0; i < strarray.length; i++) {
            System.out.print(strarray[i]);
        }
        System.out.println();
        Arrays.fill(strarray, "a");
        System.out.print("fill替换数组中所有元素：");
        for (int i = 0; i < strarray.length; i++) {
            System.out.print(strarray[i]);
        }
    }

    private static void test1() {
        List list = new ArrayList();
        list.add("admin");
        list.add("wangwu");
        list.add("zhangsan");

        list.stream().forEach(item -> {
            System.out.println(item);
        });
        Consumer<String> consumer = System.out::println;
        consumer.accept("lisi");
    }
}