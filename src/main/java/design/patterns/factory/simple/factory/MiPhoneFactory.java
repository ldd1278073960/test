package design.patterns.factory.simple.factory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class MiPhoneFactory {

    public MiPhone createMiPhone(){
        System.out.println("created 小米手机");
        return new MiPhone();
    }
}
