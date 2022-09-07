package thread.volatile1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ldp
 * @date 2021/12/30
 * 测试volatile原子性
 */
public class VolatileTest1 {

    volatile Integer count = 0;

    volatile Integer countDis = 100000;

    public void addCount(){
        for (int i = 0; i < 10000; i++) {
             synchronized (VolatileTest1.class){
                 count++;
                 countDis--;
             }
        }

    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        VolatileTest1 test1 = new VolatileTest1();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(test1::addCount,"thread-" + i));
        }
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(test1.count);
        System.out.println(test1.countDis);
        System.out.println(startTime - System.currentTimeMillis());
    }
}
