package design.patterns.strategy.demo.abstractdemo.controller;

import design.patterns.strategy.demo.DemoEnum;
import design.patterns.strategy.demo.abstractdemo.AbstractDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Ldp
 * @date 2021/11/16
 */
@RestController
@RequestMapping("/v1")
public class AbstractDemoController {

    @Autowired
    private  Map<String, AbstractDemo> abstractMsgCallBackHandlerMap;

    @RequestMapping("/v1")
    public String testDemo(Integer type){
        String name = DemoEnum.getName(type);
        AbstractDemo abstractDemo = abstractMsgCallBackHandlerMap.get(name);
        if (abstractDemo == null){
            return null;
        }
        return abstractDemo.process(type);
    }
}
