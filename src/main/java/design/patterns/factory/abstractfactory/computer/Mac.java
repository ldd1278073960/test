package design.patterns.factory.abstractfactory.computer;

/**
 * @author Ldp
 * @date 2021/11/23
 */
public class Mac extends AbstractComputerFactory {
    @Override
    public void name() {
        System.out.println("苹果笔记本");
    }
}
