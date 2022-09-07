package thread;

/**
 * @author Ldp
 * @date 2021/12/13
 */
public class ThreadTst3 {

    public synchronized void main(){
        System.out.println("fatherThreadName: " + Thread.currentThread().getName() + Thread.currentThread().getPriority());
    }

    static class Child extends ThreadTst3{

        @Override
        public synchronized void main(){
            Child child = new Child();
            System.out.println("childMain: " + Thread.currentThread().getName() + Thread.currentThread().getId());
            child.main1();
        }

        public synchronized void main1(){
            super.main();
            System.out.println("childMain1: " + Thread.currentThread().getName() + Thread.currentThread().getId());
        }

        public static void main(String[] args) {
            Child child = new Child();
            child.main();
        }
    }

}
