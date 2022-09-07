package design.patterns.factory.simple.factory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class Iphone implements Phone {

    @Override
    public void name(){
        System.out.println("苹果被咬了一口");
    }
}
