package design.patterns.factory.test;

/**
 * @author Ldp
 * @date 2021/11/26
 */
public class ActivityImpl implements IActivity{
    @Override
    public void createActivity() {
        System.out.println("创建活动");
    }
}
