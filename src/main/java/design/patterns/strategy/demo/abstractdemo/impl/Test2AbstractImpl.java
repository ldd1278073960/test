package design.patterns.strategy.demo.abstractdemo.impl;

import design.patterns.strategy.demo.abstractdemo.AbstractDemo;
import org.springframework.stereotype.Component;

/**
 * @author Ldp
 * @date 2021/11/16
 */
@Component
public class Test2AbstractImpl extends AbstractDemo {
    @Override
    protected String testDemo(Integer type) {
        return "test2";
    }
}
