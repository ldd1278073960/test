package aop.advice;

import aop.annotation.MethodLog;
import aop.annotation.MyMethodLog;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author Ldp
 * @date 2021/1/7
 */
public class MethodLogAdvice implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        this.before(method,objects,o);
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        // 获取该方法下面的所有注解
        Annotation[] annotations = method.getAnnotations();
        Class<MethodLog> obj = MethodLog.class;
        Class<MyMethodLog> myMethodLogClass = MyMethodLog.class;
        Class<RequestMapping> requestMappingClass = RequestMapping.class;
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(obj)){
                MethodLog methodLog = method.getAnnotation(obj);
                System.out.println("hello:@"+methodLog.value());
            }else if(annotation.annotationType().equals(myMethodLogClass)){
                MyMethodLog myMethodLog = method.getAnnotation(myMethodLogClass);
                System.out.println("hello: @"+ myMethodLog.value());
            }else if (annotation.annotationType().equals(requestMappingClass)){

            }
        }
    }
}
