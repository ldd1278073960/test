package com.dp.test.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.dp.test.test.utils.EnumTest;
import com.dp.test.test.utils.JSONUtils;
import com.dp.test.test.utils.RSACoderUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.time.DateFormatUtils.format;

/**
 * @author 86151*/
 

public class TestApplication {

    
    private static final String VARIABLE = "1209";



    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getMonth(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }

    /**
     * 得到某一月的开始时间
     *
     * @param month 格式yyyy-MM
     * @return
     * @author: Mancy*/
     
    public static Date getMonthStart(String month) {
        String fmt = "yyyy-MM";
        if (StringUtils.isBlank(month)) {
            month = format(getNow(), fmt);
        }
        Date time = parse(month, fmt);
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTimeInMillis(time.getTime());
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 转换时间
     *
     * @param dateStr
     * @param fmt*/
     
    public static Date parse(String dateStr, String fmt) {
        if (StringUtils.isBlank(dateStr) || StringUtils.isBlank(fmt)) {
            return null;
        }
        DateFormat formatter = new SimpleDateFormat(fmt);
        try {
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 得到当前时间
     *
     * @return
     */
     
    public static Date getNow() {
        return new Date(System.currentTimeMillis());
    }




    public static void xx(String s1,String s2){

        String s3 = "helloworld";
        String s4 = s1+s2;
        System.out.println(s3==s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }


    private static void swap(User user, User user1) {
        User user2 = user;
        user = user1;
        user1 = user2;
        System.out.println("arg1 = " + user.hashCode() + " arg2 =" + user.hashCode());
    }

    public static String getReturnNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date()) + (int) ((Math.random() * 9 + 1) * 100000);
    }

     public static void main(String[] args) {
        String str = "a_SIM_22103_20220522_00_003.dat";
         String[] s = str.split("_");
         System.out.println(s[2]);
//        System.out.println(VARIABLE);
/*         User user = new User("donf",18);
         User user1 = new User("donf",19);
         swap(user, user1);
         System.out.println("arg1 = " + user.hashCode() + " arg2 =" + user.hashCode());
         String str = "这是一个字符串";
         try {
             MessageDigest instance = MessageDigest.getInstance(str);
             byte[] digest = instance.digest(str.getBytes());
         } catch (NoSuchAlgorithmException e) {
             e.printStackTrace();
         }

         byte[] bytes = str.getBytes();
         System.out.println(Arrays.toString(bytes));


         System.out.println(getReturnNo());*/
        /* SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


         Calendar calendar1 = Calendar.getInstance();
         calendar1.set(Calendar.HOUR_OF_DAY, 0);
         calendar1.set(Calendar.SECOND, 0);
         calendar1.set(Calendar.MINUTE, 0);
         calendar1.set(Calendar.MILLISECOND, 0);
         System.out.println(sdf.format(calendar1.getTime()));
         calendar1.set(Calendar.HOUR_OF_DAY, 23);
         calendar1.set(Calendar.MINUTE, 59);
         calendar1.set(Calendar.SECOND, 59);
         calendar1.set(Calendar.MILLISECOND, 999);
         System.out.println(sdf.format(calendar1.getTime()));
        Number number = 1;*/
         System.out.println(RSACoderUtils.decrypt("1ed6973c3bd9410b4e5d1ad22ab24faa"));
       /* String str = "广东,广州市,天河区";
        String[] split = str.split(",");
        StringBuilder ext = new StringBuilder();
        for (String s : split) {
            ext.append(s);
        }
        System.out.println(
                ext
        );
        Map<String,Object> map = new HashMap<>();
        map.put("xxx",123456);
        map.put("www",123);
        String x = JSONObject.toJSONString(map);
        System.out.println(x);
        Map map1 = JSONObject.parseObject(x, Map.class);

        System.out.println(map1.get("xxx"));

        System.out.println(RSACoderUtils.decrypt("14e2601149c8df93af3eb070cf0d5d72"));

        System.out.println(RSACoderUtils.decrypt("ab809d6ec3370b3bf780bff2c348c0dc"));

        BigDecimal bigDecimal = new BigDecimal("1.324");

        System.out.println(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP));

        LocalDateTime of = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        System.out.println(of.format(dtf));

        Set<EnumTest> enumTests = EnumSet.noneOf(EnumTest.class);

        enumTests.add(EnumTest.ActivityRebateDay);
        for (EnumTest enumTest : enumTests) {
            System.out.println(enumTest);
            System.gc();
        }

        List<User> users = new ArrayList<>();
        users.add(new User("张三", 5));
        users.add(new User("李四", 5));
        users.add(new User("李四", 4));
        users.add(new User("王五", 3));
        String string = JSONObject.toJSONString(users);

        User gg = JSONUtils.gg(string, User.class);
        List<Integer> integers = Collections.singletonList(1);
        System.out.println(integers);
        List<Integer> integers1 = Arrays.asList(1,2,3,4,5);
        System.out.println(integers1);*/
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

//        Vector<Long> objects = new Vector<>();
//        objects.add(1L);
//        objects.add(2L);
//        objects.add(3L);
//        objects.add(3L);
//        System.out.println(objects);
//
        List<Long> list = null;
        test(list);
        System.out.println(list);

/*        String calc = calc(18);
        System.out.println(calc);

        String join = StringUtils.join(list, ",");
        System.out.println(join);
        List<Long> collect = list.stream().distinct().collect(Collectors.toList());
        List<Long> list1 = new ArrayList<>();
        list1.add(1L);

        List<Long> longs = (List<Long>) CollectionUtils.removeAll(list, list1);
        System.out.println(longs);

        System.out.println(EnumTest.ActivityRebateDay.toString());

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

        /*Enumeration<String> days;
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
        }

        SortedMap<String , Object> map = new TreeMap<>();
        map.put("xs",11);
        map.put("xs1",65);
        map.put("xs2",31);
        Set<Map.Entry<String, Object>> entries = map.entrySet();
        Iterator<Map.Entry<String, Object>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Object> next = iterator.next();
            System.out.println(next.getKey() + "值:" + next.getValue());
        }
        System.out.println(map);

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
        }*/

    }


    /*public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);


        // 遍历取值
        //users.forEach(e -> System.out.println(e.getName()));

        //遍历取值,存入List中
        List<String> collect = users.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(collect);

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

        List<Integer> collect = users.stream().map(User::getAge).collect(Collectors.toList());
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
        System.out.println(properties);


     String s = "176278-176200-579N2A";
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
        }
    }

    // 简单递归
    public static void fun(int n){
        if (n == 1){
            System.out.println("n等于一");
            return;
        }else {
            System.out.println("n大于1");
            fun(n-1);
        }
    }


    public static String calc(Integer param) {
        Integer[] nums = {2, 7, 11, 15};
        for (int i = 0; i < nums.length; i++) {
            Integer num = nums[i];
            for (int j = 0; j < nums.length; j++) {
                Integer integer = nums[j];
                if (num + integer == param) {
                    String s = i + "";
                    String s1 = j + "";
                    return s + "," + s1;
                }
            }
        }
        return "没有符合的结果";
    }*/
    private static void test(List<Long> list){
        double div = div(Double.parseDouble("20.0"), Double.parseDouble("30.0"), 2);
        System.out.println(new BigDecimal(div)
                .multiply(new BigDecimal("100"))
                .setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        if (b1.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO.doubleValue();
        }
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }
}
