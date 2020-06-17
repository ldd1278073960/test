package com.dp.test.test.singleton;

/**
 * @author Ldp
 * @date 2020/6/1
 * 懒汉式加载,
 * 优点:  只有当第一次调用的时候才会创建这个对象
 * 缺点:
 * 1.如果是多线程的,则不要删除变量上的volatile与方法上的synchronize,否则会出现线程非安全问题.
 * 2.但如果不删除变量上的volatile与方法上的synchronize,虽然保证了线程的安全,但是每次访问的时候都是同步的,会影响性能,而且会消耗更多的资源
 */
public class LazySingleton {

    private static volatile LazySingleton instance=null; // 保证在所有线程中同步

    private LazySingleton(){} // 避免类在外部被实例化

    // 方法加上同步锁
    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            instance = new LazySingleton();
        }
        return instance;
    }

}
