package thread;

import java.util.concurrent.Executors;

/**
 * @author Ldp
 * @date 2021/12/13
 */
public class ThreadTest1 {

    public static synchronized void thread1(){
        System.out.println("111");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end 1");
    }

    public static void thread2(){
        System.out.println("222");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end 2");
    }

    public static void main(String[] args) {
        new Thread(ThreadTest1::thread1,"t1").start();

        new Thread(ThreadTest1::thread2,"t2").start();
    }
}
