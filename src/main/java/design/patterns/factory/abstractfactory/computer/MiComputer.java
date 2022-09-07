package design.patterns.factory.abstractfactory.computer;

/**
 * @author Ldp
 * @date 2021/11/23
 */
public class MiComputer extends AbstractComputerFactory {
    @Override
    public void name() {
        System.out.println("小米电脑");
    }
}
