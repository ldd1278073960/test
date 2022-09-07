package design.patterns.singleton;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ldp
 * @date 2021/10/8
 */
public class Main {
    public static void main(String[] args) {
        LazySingleton instance1 = LazySingleton.getInstance();
        instance1.setB("ssss");
        LazySingleton instance2 = LazySingleton.getInstance();
        System.out.println(instance1 == instance2);
        System.out.println(instance2.getB());

        List<LazySingleton> lazySingletons = new ArrayList<>();
        lazySingletons.add(instance1);
        instance2.setA(1L);
        lazySingletons.add(instance2);
        System.out.println(JSONObject.toJSONString(lazySingletons));
    }
}
