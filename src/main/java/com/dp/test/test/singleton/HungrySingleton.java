package com.dp.test.test.singleton;

/**
 * @author Ldp
 * @date 2020/6/1
 * 优点:
 * 类一单加载就创建一个单例,保证在调用getInstance方法前已经创建好了
 * 该模式是在类创建的同时就创建好了一个静态的对象供系统使用,不再改变,所以是线程安全的,直接用于多线程且不会出现问题
 */
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static  HungrySingleton getInstance(){
        return hungrySingleton;
    }

}
