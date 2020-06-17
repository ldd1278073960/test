package com.dp.test.test;

import lombok.Data;

/**
 * @author Ldp
 * @date 2020/3/24
 */
@Data
public class User {

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;
}
