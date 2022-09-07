package design.patterns.factory.abstractfactory.phone;


/**
 * @author Ldp
 * @date 2021/11/22
 */
public class PineapplePhoneFactory extends AbstractPhoneFactory {
    @Override
    public void name(){
        System.out.println("美国有苹果，中国有菠萝，菠萝手机！");
    }
}
