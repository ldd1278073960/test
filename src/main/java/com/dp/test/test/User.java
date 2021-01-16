package com.dp.test.test;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author Ldp
 * @date 2020/3/24
 */
@Data
public class User extends Person {

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @NotBlank(message = "验证字符串非null，且长度必须大于0")
    private String name;

    @Min(value = 0 , message = "年龄不能小于0")
    private int age;
}
