package design.patterns.factory.abstractfactory.phone;


/**
 * @author Ldp
 * @date 2021/11/22
 */
public class MiPhone extends AbstractPhoneFactory {

    @Override
    public void name(){
        System.out.println("谁特么买小米儿");
    }

}
