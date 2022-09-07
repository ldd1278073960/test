package com.dp.test.test;

import com.alibaba.fastjson.JSONObject;
import com.dp.test.test.utils.JacksonUtil;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ldp
 * @date 2021/1/6
 */
@Data
public class Person {

    private Date createTime;

    private Integer id;

    private String name;

    public static void main(String[] args) {


        List<User> users = new ArrayList<>();
        users.add(new User("张三", 5));
        users.add(new User("李四", 5));
        users.add(new User("李四", 4));
        users.add(new User("王五", 3));
        String string = JSONObject.toJSONString(users);
        System.out.println(string);

        Person person = new Person();
        person.setCreateTime(new Date());
        person.setId(12);
        person.setName("scs");
        List<Person> list = new ArrayList<>();
        list.add(person);
        for (Person person1 : list) {
            System.out.println(person1);
        }
        Map<String, Object> param = new HashMap<>();
        param.put("frozenStockVos", list);
        String jackson = JSONObject.toJSONString(param);
        com.alibaba.fastjson.JSONObject jsonObject1 = new com.alibaba.fastjson.JSONObject();
        jsonObject1.put("frozenStock", jackson);
        System.out.println(jsonObject1);

        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(jsonObject1), JSONObject.class);
        String frozenStock = jsonObject.getString("frozenStock");
        Map<String, Object> map = JSONObject.parseObject(frozenStock, Map.class);
        List<Person1> frozenStockVos = (List<Person1>) map.get("frozenStockVos");
        String frozenStockVos1 = JSONObject.toJSONString(map.get("frozenStockVos"));
        List<Person1> person1s = JSONObject.parseArray(frozenStockVos1, Person1.class);
        System.out.println(person1s);
        for (Person1 frozenStockVo : person1s) {

        }
    }


    private void packageUserInteractionEnum(Long userId, List<Long> otherQueryUserIdList) {
    }
}
