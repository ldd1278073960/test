package com.dp.test.test.utils;

/**
 * @author Ldp
 * @date 2020/11/9
 */
public enum EnumTest {

    ConsumeBack("消费者消费返现"),
    ActivityRebateDay("签收激活返佣天数");

    private String name;

    EnumTest(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
