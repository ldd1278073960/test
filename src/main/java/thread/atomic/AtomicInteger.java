package thread.atomic;

import org.apache.commons.lang3.StringUtils;
import sun.misc.Unsafe;
import thread.volatile1.VolatileTest1;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Ldp
 * @date 2021/12/30
 * CAS 无锁优化
 */
public class AtomicInteger {



    /**
     * AtomicInteger类本身方法是原子性的，且是线程安全的，但不能保证多个方法调用是原子性
     */
    static  java.util.concurrent.atomic.AtomicInteger count = new java.util.concurrent.atomic.AtomicInteger(0);

    private static LongAdder count3 = new LongAdder();

    public static void addCount() {
        for (int i = 0; i < 10000; i++) {
            // 原本需要加锁才行，但是使用AtomicInteger可以不用加锁
            /*synchronized (VolatileTest1.class){*/

            // 相当于count++，但是它为线程安全的
            count3.increment();
            System.out.println(count3);
            /* }*/
        }
        System.out.println(count3);
    }

    public static void main(String[] args) {

        addCount();
    }
}
