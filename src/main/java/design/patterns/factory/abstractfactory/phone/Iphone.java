package design.patterns.factory.abstractfactory.phone;


/**
 * @author Ldp
 * @date 2021/11/22
 */
public class Iphone extends AbstractPhoneFactory {

    @Override
    public void name(){
        System.out.println("苹果被咬了一口");
    }
}
