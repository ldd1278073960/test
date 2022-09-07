package thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author Ldp
 * @date 2022/1/12
 */
public class AtomicLongAdder {
    private static Integer count1 = 0;
    private static AtomicInteger count2 = new AtomicInteger(0);
    private static LongAdder count3 = new LongAdder();


    public static void main(String[] args) throws InterruptedException {



        Thread[] threads = new Thread[100];
        Object lock = new Object();

        // 使用synchronize 查看自增速度 start
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    synchronized (lock){
                        count1++;
                    }
                }
            });
        }
        isTime(threads);
        // 使用synchronize 查看自增速度 end


        // 使用increment 查看自增速度 start
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    count2.getAndIncrement();
                }
            });
        }
        isTime(threads);
        // 使用increment 查看自增速度 end

        // 使用LongAdder 查看自增速度 start
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 1000; i1++) {
                    count3.increment();
                }
            });
        }
        isTime(threads);
        // 使用LongAdder 查看自增速度 end
    }

    private static void isTime(Thread[] threads)throws InterruptedException{
        long startTime = System.currentTimeMillis();
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }

}
