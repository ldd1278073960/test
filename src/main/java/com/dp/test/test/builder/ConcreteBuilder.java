package com.dp.test.test.builder;

/**
 * @author Ldp
 * @date 2020/6/1
 * 具体建造者：实现了抽象建造者接口。
 */
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
         product.setPartA("这是A");
    }

    @Override
    public void buildPartB() {
        product.setPartA("这是B");
    }

    @Override
    public void buildPartC() {
        product.setPartA("这是C");
    }
}
