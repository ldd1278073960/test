package design.patterns.factory.simple.factory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class SimplePhoneFactory {

    public MiPhone createMiPhone(){
        return new MiPhone();
    }

    public PineapplePhone createPineapplePhone(){
        return new PineapplePhone();
    }
}
