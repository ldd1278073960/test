package thread.synchronize1;

import java.util.concurrent.TimeUnit;

/**
 * @author Ldp
 * @date 2021/12/30
 * 测试Synchronize锁对象时，如果对象的值发生改变，会出现什么情况
 *
 * 如果锁对象时，对象的值发生了改变，则别的线程就会一起运行。所以需要在对象上面加上final参数，使对象不可被改变
 */
public class SynchronizeTest {

   /*final */Object o = new Object();

    void m(){
        synchronized(o){
            while(true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        SynchronizeTest synchronizeTest = new SynchronizeTest();

        new Thread(synchronizeTest::m).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(synchronizeTest::m, "t2");

        // 如果下面这行代码不能运行或者注释掉，则线程t2永远不会执行
        synchronizeTest.o = new Object();

        t2.start();
    }
}
