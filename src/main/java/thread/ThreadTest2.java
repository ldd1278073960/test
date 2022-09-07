package thread;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Ldp
 * @date 2021/12/13
 */

public class ThreadTest2 {

    private String name;

    private BigDecimal balance = new BigDecimal("0.00");

    public synchronized void set(String name, BigDecimal balance) {
        this.name = name;
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }


    public BigDecimal getBalance(String name){
        return this.balance;
    }

    public static void main(String[] args) {
        ThreadTest2 threadTest2 = new ThreadTest2();
        new Thread(()-> threadTest2.set("liu",new BigDecimal("1.01"))).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadTest2.getBalance("liu"));

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadTest2.getBalance("liu"));
    }
}
