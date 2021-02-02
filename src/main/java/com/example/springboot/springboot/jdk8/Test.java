package com.example.springboot.springboot.jdk8;

import com.example.springboot.springboot.jdk8.entity.LossPartyDto;
import com.example.springboot.springboot.jdk8.entity.LossPartyDtoItem;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Consumer;

@Slf4j
public class Test {
    public static void main(String[] args) {
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
        test05();
    }

    private static void test05() {
        List<LossPartyDto> lossPartyDtoList1 = new ArrayList<>();
        List<LossPartyDto> lossPartyDtoList2 = new ArrayList<>();
        List<LossPartyDto> lossPartyDtoList3 = new ArrayList<>();

        List<LossPartyDtoItem> lossPartyDtoItemArrayList1 = new ArrayList<>();
        List<LossPartyDtoItem> lossPartyDtoItemArrayList2 = new ArrayList<>();

        LossPartyDtoItem a1 = new LossPartyDtoItem();
        a1.setUniqueNo(1l);
        a1.setStatus("01");
        a1.setName("1111111111111zhangsan");
        lossPartyDtoItemArrayList1.add(a1);

        a1 = new LossPartyDtoItem();
        a1.setUniqueNo(2l);
        a1.setStatus("01");
        a1.setName("11111111111list");
        lossPartyDtoItemArrayList1.add(a1);
        LossPartyDto lossPartyDto1 = new LossPartyDto();
        lossPartyDto1.setUniqueNo(001l);
        lossPartyDto1.setLossPartyDtoItemList(lossPartyDtoItemArrayList1);
        lossPartyDtoList1.add(lossPartyDto1);

        lossPartyDtoItemArrayList1 = new ArrayList<>();
        a1 = new LossPartyDtoItem();
        a1.setUniqueNo(3l);
        a1.setStatus("01");
        a1.setName("1111111111111zhangsan");
        lossPartyDtoItemArrayList1.add(a1);

        a1 = new LossPartyDtoItem();
        a1.setUniqueNo(4l);
        a1.setStatus("01");
        a1.setName("11111111111list");
        lossPartyDtoItemArrayList1.add(a1);
        LossPartyDto lossPartyDto2 = new LossPartyDto();
        lossPartyDto2.setUniqueNo(002l);
        lossPartyDto2.setLossPartyDtoItemList(lossPartyDtoItemArrayList1);
        lossPartyDtoList1.add(lossPartyDto2);

//////////////////////////////////////////////////////////////////////////////////
        LossPartyDtoItem b = new LossPartyDtoItem();
        b.setUniqueNo(1l);
        b.setStatus("00");
        b.setName("22222222222");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(3l);
        b.setStatus("00");
        b.setName("2222222222jjjjj");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(4l);
        b.setStatus("00");
        b.setName("222222222ddddd");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(5l);
        b.setStatus("00");
        b.setName("222222222ssssss");
        lossPartyDtoItemArrayList2.add(b);
        LossPartyDto lossPartyDto212 = new LossPartyDto();
        lossPartyDto212.setUniqueNo(001l);
        lossPartyDto212.setLossPartyDtoItemList(lossPartyDtoItemArrayList2);
        lossPartyDtoList2.add(lossPartyDto212);

        //////////////////////////////////////////////////////////////////
        lossPartyDtoItemArrayList2 = new ArrayList<>();
        b = new LossPartyDtoItem();
        b.setUniqueNo(3l);
        b.setStatus("00");
        b.setName("22222222222");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(4l);
        b.setStatus("00");
        b.setName("2222222222jjjjj");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(5l);
        b.setStatus("00");
        b.setName("222222222ddddd");
        lossPartyDtoItemArrayList2.add(b);

        b = new LossPartyDtoItem();
        b.setUniqueNo(6l);
        b.setStatus("00");
        b.setName("222222222ssssss");
        lossPartyDtoItemArrayList2.add(b);
        lossPartyDto2 = new LossPartyDto();
        lossPartyDto2.setUniqueNo(003l);
        lossPartyDto2.setLossPartyDtoItemList(lossPartyDtoItemArrayList2);
        lossPartyDtoList2.add(lossPartyDto2);

        Map<Long, LossPartyDto> longLossPartyDtoMap=new HashMap<>();
        Map<Long, LossPartyDtoItem> longLossPartyDtoItemMap=new HashMap<>();
        List<LossPartyDto> partyDtoArrayList=new ArrayList<>();
        LossPartyDto lossPartyDto4 = new LossPartyDto();
        String uniqueNo="";
        //理赔
        for(LossPartyDto lossPartyDto : lossPartyDtoList1){
            List<LossPartyDtoItem> lossPartyDtoItemList = lossPartyDto.getLossPartyDtoItemList();
            //公估系统
            for(LossPartyDto newLossPartyDto : lossPartyDtoList2) {
                List<LossPartyDtoItem> newLossPartyDtoItemList = newLossPartyDto.getLossPartyDtoItemList();
                for(LossPartyDtoItem lossPartyDtoItem : lossPartyDtoItemList){
                    if("01".equals(lossPartyDtoItem.getStatus())|| "02".equals(lossPartyDtoItem.getStatus())){
                        longLossPartyDtoItemMap.put(lossPartyDtoItem.getUniqueNo(), lossPartyDtoItem);
                    }
                    for(LossPartyDtoItem newLossPartyDtoItem : newLossPartyDtoItemList){
                        longLossPartyDtoItemMap.put(newLossPartyDtoItem.getUniqueNo(), newLossPartyDtoItem);
                    }
                }
                List<LossPartyDtoItem> lossPartyDtoItemArrayList = new ArrayList<>(longLossPartyDtoItemMap.values());
                lossPartyDto4.setLossPartyDtoItemList(lossPartyDtoItemArrayList);
                lossPartyDto4.setUniqueNo(newLossPartyDto.getUniqueNo());
                longLossPartyDtoMap.put(lossPartyDto4.getUniqueNo(), lossPartyDto4);
            }
        }

        List<LossPartyDto> lossPartyDtosResult = new ArrayList<>(longLossPartyDtoMap.values());
        for (LossPartyDto lossPartyDtoResult : lossPartyDtosResult) {
            log.info("===" + lossPartyDtoResult.getUniqueNo() + "===" + lossPartyDtoResult.getLossPartyDtoItemList().size());
            List<LossPartyDtoItem> lossPartyDtoItemList = lossPartyDtoResult.getLossPartyDtoItemList();
            for (LossPartyDtoItem lossPartyDtoItem : lossPartyDtoItemList) {
                log.info("---" + lossPartyDtoItem.getUniqueNo() + "---" + lossPartyDtoItem.getStatus() + "---" + lossPartyDtoItem.getName());
            }
        }





















//        log.info("----------------------lossPartyDtoList1理赔转换前------------------------");
//        for (LossPartyDto lossPartyDto : lossPartyDtoList1) {
//            log.info("===" + lossPartyDto.getUniqueNo() + "===" + lossPartyDto.getLossPartyDtoItemList().size());
//            List<LossPartyDtoItem> lossPartyDtoItemList = lossPartyDto.getLossPartyDtoItemList();
//            for (LossPartyDtoItem lossPartyDtoItem : lossPartyDtoItemList) {
//                log.info("---" + lossPartyDtoItem.getUniqueNo() + "---" + lossPartyDtoItem.getStatus() + "---" + lossPartyDtoItem.getName());
//            }
//        }
//        log.info("----------------------lossPartyDtoList2公估系统转换前------------------------");
//        for (LossPartyDto lossPartyDtoResult : lossPartyDtoList2) {
//            log.info("===" + lossPartyDtoResult.getUniqueNo() + "===" + lossPartyDtoResult.getLossPartyDtoItemList().size());
//            List<LossPartyDtoItem> lossPartyDtoItemList = lossPartyDtoResult.getLossPartyDtoItemList();
//            for (LossPartyDtoItem lossPartyDtoItem : lossPartyDtoItemList) {
//                log.info("---" + lossPartyDtoItem.getUniqueNo() + "---" + lossPartyDtoItem.getStatus() + "---" + lossPartyDtoItem.getName());
//            }
//        }









        /*List<LossPartyDto> lossPartyDtoList1 = new ArrayList<>();
        List<LossPartyDto> lossPartyDtoList2 = new ArrayList<>();
        List<LossPartyDto> lossPartyDtoList3 = new ArrayList<>();

        List<A> listA = new ArrayList<>();
        List<A> listB = new ArrayList<>();

        A a1 = new A();
        a1.setUniqueNo(1l);
        a1.setStatus("01");
        a1.setName("1111111111111zhangsan");
        listA.add(a1);

        a1 = new A();
        a1.setUniqueNo(2l);
        a1.setStatus("01");
        a1.setName("11111111111list");
        listA.add(a1);
        LossPartyDto lossPartyDto1 = new LossPartyDto();
        lossPartyDto1.setUniqueNo(001l);
        lossPartyDto1.setAList(listA);
        lossPartyDtoList1.add(lossPartyDto1);

//////////////////////////////////////////////////////////////////////////////////
        A b = new A();
        b.setUniqueNo(1l);
        b.setStatus("00");
        b.setName("22222222222");
        listB.add(b);

        b = new A();
        b.setUniqueNo(3l);
        b.setStatus("00");
        b.setName("2222222222jjjjj");
        listB.add(b);

        b = new A();
        b.setUniqueNo(4l);
        b.setStatus("00");
        b.setName("222222222ddddd");
        listB.add(b);

        b = new A();
        b.setUniqueNo(5l);
        b.setStatus("00");
        b.setName("222222222ssssss");
        listB.add(b);
        LossPartyDto lossPartyDto2 = new LossPartyDto();
        lossPartyDto2.setUniqueNo(001l);
        lossPartyDto2.setAList(listB);
        lossPartyDtoList2.add(lossPartyDto2);

        lossPartyDto2 = new LossPartyDto();
        lossPartyDto2.setUniqueNo(003l);
        lossPartyDto2.setAList(listB);
        lossPartyDtoList2.add(lossPartyDto2);

        LossPartyDto lossPartyDtoResult;
        Map<Long, A> map = new HashMap<>();
        Map<Long, LossPartyDto> lossPartyDtoMap = new HashMap<>();
        for (LossPartyDto lossPartyDto : lossPartyDtoList1) {
            Long uniqueNo = lossPartyDto.getUniqueNo() == null ? 0l : lossPartyDto.getUniqueNo();
            lossPartyDtoMap.put(lossPartyDto.getUniqueNo(), lossPartyDto);
            for (LossPartyDto newLossPartyDto : lossPartyDtoList2) {
                Long newUniqueNo = newLossPartyDto.getUniqueNo() == null ? 0l : newLossPartyDto.getUniqueNo();
                if (uniqueNo.equals(newUniqueNo)) {
                    //比较
                    List<A> aList1 = lossPartyDto.getAList();
                    List<A> aList2 = newLossPartyDto.getAList();
                    for (A list1 : aList1) {
                        if ("01".equals(list1.getStatus()) || "02".equals(list1.getStatus())) {
                            map.put(list1.getUniqueNo(), list1);
                        }
                        for (A list2 : aList2) {
                            map.put(list2.getUniqueNo(), list2);
                        }
                    }
                    List<A> list12 = new ArrayList<>(map.values());
                    lossPartyDtoResult=new LossPartyDto();
                    lossPartyDtoResult.setAList(list12);
                    lossPartyDtoResult.setUniqueNo(newLossPartyDto.getUniqueNo());
                }else {
                    //beanutils.copy(newLossPartyDto, lossPartyDtoResult)
                    lossPartyDtoResult=new LossPartyDto();
                    lossPartyDtoResult.setAList(newLossPartyDto.getAList());
                    lossPartyDtoResult.setUniqueNo(newLossPartyDto.getUniqueNo());
                }
                lossPartyDtoList3.add(lossPartyDtoResult);
            }
        }

        for (LossPartyDto bbb : lossPartyDtoList3) {
            System.out.println("===" + bbb.getUniqueNo() + "==="+ bbb.getAList().size());
            for(A a :bbb.getAList()){
                System.out.println("---"+ a.getUniqueNo()+"---"+a.getStatus()+"---"+a.getName());
            }
        }*/
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
        System.out.println(str3 == str4);//false
        System.out.println(str1.equals(str2));//true
        System.out.println(str3.equals(str4));//true
        System.out.println(str1.equals(str4));//true
        System.out.println(str1.equals(str4));//true
        System.out.println(str5.equals(str6));//true
        System.out.println(str5 == str6);//false
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
        Consumer<String> consumer = (str) -> System.out.println(str);
        consumer.accept("lisi");
    }
}

























