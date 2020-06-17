package com.dp.test.test;

import com.dp.test.test.builder.Builder;
import com.dp.test.test.builder.ConcreteBuilder;
import com.dp.test.test.builder.Director;
import com.dp.test.test.builder.Product;
import com.dp.test.test.singleton.LazySingleton;
import org.junit.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 86151
 */
@SpringBootApplication
public class TestApplication {

    /*public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
        List<User> users = new ArrayList<>();
        users.add(new User("张三", 5));
        users.add(new User("李四", 4));
        users.add(new User("王五", 3));

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
    }

    @Builder
    @Test
    public void gg() throws Exception{
        // 根据路径获取对象
        Class<?> clazz = Class.forName("com.dp.test.test.User");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("clazz== "+clazz);

        List<Map<String , Object>> list = new ArrayList<>();

        List<Object> collect = list.stream().filter(e -> !e.get("ss").equals(0)).map(e -> Long.parseLong(e.get("xx").toString())).collect(Collectors.toList());

        // 根据类.class 获取对象
        Class<User> userClass = User.class;
        System.out.println("userClass=="+userClass);

        Channel channel = RabbitMqConfig.channel;



        channel.basicPublish("exchangeName","routingKey",true, MessageProperties.TEXT_PLAIN,"Hello World!!".getBytes());
    }*/

    private static volatile LazySingleton instance=null;

    @Test
    public void LazySingleton(){

    }

    @Test
    public void Client(){
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.construct();
        String s = "sggNsd";
        String[] split = s.split("N*APPLICATION PROGRAM COMMAND}");
        product.show();
    }

    public void testClient(){
    }

}
