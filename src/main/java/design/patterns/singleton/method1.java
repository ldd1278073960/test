package design.patterns.singleton;

/**
 * @author Ldp
 * @date 2021/10/8
 */
public enum  method1 {

    INSTANCE;

    private method1() {
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(method1.INSTANCE.hashCode())).start();
        }
    }

}
