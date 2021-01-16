package aop.service;

import aop.annotation.MethodLog;
import aop.annotation.MyMethodLog;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public interface NoticeService {

    @MethodLog("执行 name")
    void sayHello(String name);


    @MyMethodLog("执行 self")
    void sayMySelf(String self);
}
