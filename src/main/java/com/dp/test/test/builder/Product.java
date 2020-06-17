package com.dp.test.test.builder;

import lombok.Setter;

/**
 * @author Ldp
 * @date 2020/6/1
 * 产品角色: 包含多个组成部件的复杂对象
 */
@Setter
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void show(){
        // 显示产品的新特性
    }
}
