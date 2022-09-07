package design.patterns.strategy.demo.abstractdemo;

import org.springframework.stereotype.Component;

import javax.validation.groups.Default;

/**
 * @author Ldp
 * @date 2021/11/16
 */
public abstract class AbstractDemo {

    public String process(Integer type){
        return this.testDemo(type);
    }


    /**
     * 测试抽象方法代码
     * @param type 测试类型
     * @return 接口信息
     */
    protected abstract String testDemo(Integer type);


    Default aDefault(){
        return null;
    }
}
