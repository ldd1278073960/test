package design.patterns.singleton;

/**
 * @author Ldp
 * @date 2020/6/1
 * 懒汉式加载,
 * 优点:  只有当第一次调用的时候才会创建这个对象
 * 缺点:
 * 1.如果是多线程的,则不要删除变量上的volatile与方法上的synchronize,否则会出现线程非安全问题.
 * 2.但如果不删除变量上的volatile与方法上的synchronize,虽然保证了线程的安全,但是每次访问的时候都是同步的,会影响性能,而且会消耗更多的资源
 */
public class LazySingleton {

    /** 保证在所有线程中同步*/
    private static volatile LazySingleton instance=null;

    /** 避免类在外部被实例化*/
    private LazySingleton(){}

    // 方法加上同步锁
    public static  LazySingleton getInstance(){
        if (instance == null){
            synchronized(LazySingleton.class){
                if (instance == null){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    private Long a;

    private String b;

    public Long getA() {
        return a;
    }

    public void setA(Long a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(LazySingleton.getInstance().hashCode())).start();
        }
    }
}
