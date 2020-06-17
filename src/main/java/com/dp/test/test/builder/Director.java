package com.dp.test.test.builder;

/**
 * @author Ldp
 * @date 2020/6/1
 */
public class Director {

    private Builder builder;

    public Director(Builder builder)
    {
        this.builder=builder;
    }

    public Product construct(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getResult();
    }


}
