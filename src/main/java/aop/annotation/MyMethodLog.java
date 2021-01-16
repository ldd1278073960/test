package aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Ldp
 * @date 2021/1/7
 */
@Target({ ElementType.METHOD })
@Retention(RUNTIME)
public @interface MyMethodLog {
    String value() default "";
}