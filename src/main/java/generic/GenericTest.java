package generic;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;

/**
 * @author Ldp
 * @date 2021/9/1
 */
public class GenericTest {

    public static void main(String[] args) {
        Class<? super Integer> superclass = Integer.class.getSuperclass();

        String name = superclass.getName();
//        System.out.println(name);

        Generic[] genericsArr = new Generic[2];
        genericsArr[1] = new Generic<Integer>(1,2);

        Generic<String>[] generics = (Generic<String>[]) genericsArr;


        generics[0] = new Generic<>("a","b");
//        System.out.println(JSONObject.toJSONString(generics[0]));

        generics[1] = genericsArr[1];
//        System.out.println((String) generics[1].getAge());

        String[] arr = createArr(String.class);
        Integer[] arr1 = createArr(Integer.class);

        String[] arr2 = createArr("1", "2", "3");

        JSONArray objects = JSONObject.parseArray("[{\"specId\":1,\"name\":\"规格\",\"valId\":\"62609\",\"value\":\"(25g+65g+100ml+100ml)/套\"}]");
        JSONObject jsonObject = JSONObject.parseObject(JSONObject.toJSONString(objects.get(0)));
        System.out.println(jsonObject.get("value").toString());
    }

    static <T> T[] createArr(Class<T> clz){
        return (T[]) Array.newInstance(clz,5);
    }

    static <t> t[] createArr(t... obj){
        return obj;
    }
}
