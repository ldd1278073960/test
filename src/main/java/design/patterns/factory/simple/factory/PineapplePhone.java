package design.patterns.factory.simple.factory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class PineapplePhone implements Phone {
    @Override
    public void name(){
        System.out.println("美国有苹果，中国有菠萝，菠萝手机！");
    }
}
