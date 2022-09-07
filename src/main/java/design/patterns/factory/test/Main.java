package design.patterns.factory.test;

/**
 * @author Ldp
 * @date 2021/11/26
 */
public class Main {

    public static void main(String[] args) {
        IActivity activity = ActivityFactory.createActivity(1);
        activity.createActivity();
    }
}
