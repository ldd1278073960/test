package design.patterns.factory.simple.factory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class Main  {


    public static void main(String[] args) {
        Phone p = new MiPhoneFactory().createMiPhone();
        p.name();
    }
}
