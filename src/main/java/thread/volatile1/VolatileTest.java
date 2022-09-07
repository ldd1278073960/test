package thread.volatile1;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author Ldp
 * @date 2021/12/17
 */
public class VolatileTest {

    volatile boolean xx = true;

    void t() {
        BigDecimal bb = new BigDecimal("12222222222222222222222222222222");
        System.out.println(bb);
        while (xx) {

        }
        System.out.println("end");
    }

    public static void main(String[] args) {
        VolatileTest volatileTest = new VolatileTest();

        new Thread(volatileTest::t,"t1").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        volatileTest.xx = false;
    }
}
