package design.patterns.strategy.demo;

import lombok.Getter;

/**
 * @author Ldp
 * @date 2021/11/16
 */
@Getter
public enum  DemoEnum {

    /**
     * 测试数据1
     */
    Test1(1,"test1AbstractImpl"),
    /**
     * 测试数据2
     */
    Test2(2,"test2AbstractImpl");


    private Integer type;

    private String name;


    DemoEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public static String getName(Integer type){
        for (DemoEnum value : DemoEnum.values()) {
            if (value.type.equals(type)){
                return value.name;
            }
        }
        return null;
    }

    public static String getName(DemoEnum demoEnum){
        for (DemoEnum value : DemoEnum.values()) {
            if (value.toString().equals(demoEnum.toString())){
                return value.name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String name = getName(Test1);
        System.out.println(name);
    }
}
