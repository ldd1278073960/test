package com.dp.test.test;

import com.dp.test.test.utils.EnumTest;
import com.dp.test.test.utils.Marge;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 86151
 */

public class TestApplication {


    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {


//        int a = 1;
//        int b = 1;
//        for (int i = 0 ;i < 10; i++ ){
//            int c = a + b;
//            System.out.println("a="+ a +"---b=" + b + "---c=" + c);
//            a = b;
//            b = c;
//        }
//
//        int[] ints = {8, 5, 3, 12 , 6, 1, 10};
//
//        Marge.merge_sort1(ints);

        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(3L);
        List<Long> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);
/*        List<Long> list1 = new ArrayList<>();
        list1.add(1L);

        List<Long> longs = (List<Long>) CollectionUtils.removeAll(list, list1);
        System.out.println(longs);

        System.out.println(EnumTest.ActivityRebateDay.toString());*/
/*
        Map<String,Object> map = new HashMap<>();
        map.put("xs",11);
        map.put("xs1",65);
        map.put("xs2",31);

        for (Map.Entry<String, Object> stringObjectEntry : map.entrySet()) {
            System.out.println(stringObjectEntry.getKey() + ":" + stringObjectEntry.getValue());
        }*/


//        BitSet bitSet = new BitSet(16);
//        BitSet bits2 = new BitSet(16);
//        for (int i = 0 ; i < 16 ; i++){
//            if (i%3 == 0)  bitSet.set(i);
//            if((i%4) == 0) bits2.set(i);
//        }
//
//        bits2.and(bitSet);
//        System.out.println(bits2);

        // 把不相同的全都输出
//        bits2.or(bitSet);
//        System.out.println(bits2);

        // 把一样的筛选掉
//        bits2.xor(bitSet);
//        System.out.println(bits2);

 /*       Enumeration<String> days;
        Vector<String> dayNames = new Vector<>();
        dayNames.add("Sunday");
        dayNames.add("Monday");
        dayNames.add("Tuesday");
        dayNames.add("Wednesday");
        dayNames.add("Thursday");
        dayNames.add("Friday");
        dayNames.add("Saturday");
        days = dayNames.elements();
        while (days.hasMoreElements()){
            System.out.println(days.nextElement());
        }*/

/*        SortedMap<String , Object> map = new TreeMap<>();
        map.put("xs",11);
        map.put("xs1",65);
        map.put("xs2",31);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + "值:" + next.getValue());
        }
        System.out.println(map);*/

        List<User> users = new ArrayList<>();
        users.add(new User("张三", 5));
        users.add(new User("李四", 5));
        users.add(new User("李四", 4));
        users.add(new User("王五", 3));
        List<String> collect1 = users.stream().map(User::getName).collect(Collectors.toList());

        System.out.println(collect1);

        List<User> users1 = users.stream().filter(user -> user.getAge() == 5).collect(Collectors.toList());
        System.out.println(users1);


        System.out.println(dtf.format(LocalDateTime.now()));

        String str = "1452#1-1365#4";
        String[] split = str.split("-");
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            String[] split1 = s.split("#");
            String itemId = split1[0];
            String num = split1[1];
            System.out.println(itemId+num);
        }

    }


    /*public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);


        // 遍历取值
        //users.forEach(e -> System.out.println(e.getName()));

        //遍历取值,存入List中
*//*        List<String> collect = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(collect);*//*

        // 取出年龄等于0的人物姓名
        //users.stream().filter(e -> "0".equals(String.valueOf(e.getAge()))).forEach(user -> System.out.println(user.getName()));

        // 去除重复数据
        //users.stream().distinct().forEach(user -> System.out.println(user.getAge()+user.getName()));

        // 单条件正序排序
        //users.stream().sorted(Comparator.comparing(User::getAge)).forEach(user -> System.out.println(user.getName()));

        // 多条件正序排序
        //users.stream().sorted(Comparator.comparing(User::getName).thenComparing(User::getAge)).forEach(user -> System.out.println(user.getName()+user.getAge()));

        System.out.println(users.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting())));

        //users.stream().map(e -> String.valueOf(e.getAge())).collect()

*//*        List<Integer> collect = users.stream().map(User::getAge).collect(Collectors.toList());
        List<String> collect1 = users.stream().map(User::getName).collect(Collectors.toList());

        List<User> users1 = new ArrayList<>();

        for (User user : users1) {
            System.out.println(user);
        }
        for (String s : collect1) {
            System.out.println(s);
        }
        for (Integer c : collect) {
            System.out.println(c);
        }
        double d1 = 123.01;
        double d2 = 123.012;
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        int i = b1.compareTo(b2);
        if (i == 0) {
            System.out.println(d1 + d2);
        }
        System.out.println(collect.toString() + collect1.toString());
        int i2 = 1-6*0;
        assert i2 == 0;
        System.out.println("assert" + i2);

        Map<String , Object> map = new HashMap<>();
        map.put("d1",d1);
        int d = MapUtils.getIntValue(map, "d", 10);
        Properties properties = MapUtils.toProperties(map);
        System.out.println(properties);*//*


     *//*String s = "176278-176200-579N2A";
        List list = new ArrayList<>();
        String[] prdArr = StringUtils.split(s, "A");
        if (prdArr != null && prdArr.length > 0) {
            for (String prdStr : prdArr) {
                if (StringUtils.isBlank(prdStr)) {
                    continue;
                }
                String[] prdStrArr = StringUtils.split(prdStr, "N");
                if (prdStrArr == null || prdStrArr.length < 2) {
                    continue;
                }
                if (StringUtils.isBlank(prdStrArr[0])) {
                    continue;
                }
                String[] split = StringUtils.split(prdStr, "-");
                list.add(split[0]);
            }
        }*//*
    }*/

/*    // 简单递归
    public static void fun(int n){
        if (n == 1){
            System.out.println("n等于一");
            return;
        }else {
            System.out.println("n大于1");
            fun(n-1);
        }
    }*/




}
