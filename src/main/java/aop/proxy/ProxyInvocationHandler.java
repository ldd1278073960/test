package aop.proxy;

import aop.annotation.MethodLog;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public class ProxyInvocationHandler implements InvocationHandler {

    private Object target;

    public ProxyInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        boolean annotationPresent = method.isAnnotationPresent(MethodLog.class);
        if (annotationPresent){
            System.out.println(method.getName() + "begin");
        }

        //通过反射的方式调用被代理的对象的方法
        Object ret = method.invoke(target, objects);

        if (annotationPresent) {
            System.out.println(method.getName() + " End.");
        }
        return ret;
    }
}
