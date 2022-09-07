package design.patterns.factory.test;

/**
 * @author Ldp
 * @date 2021/11/26
 */
public class ActivityFactory {

    public static IActivity createActivity(Integer type){
        if (type == 1){
            return new ActivityImpl();
        }
        return null;
    }

}
