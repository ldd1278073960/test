package design.patterns.factory.abstractfactory;

import design.patterns.factory.abstractfactory.computer.Mac;
import design.patterns.factory.abstractfactory.phone.Iphone;

/**
 * @author Ldp
 * @date 2021/11/23
 */
public class MacFactory extends AbstractElectronicProductFactory {

    @Override
    public Mac createComputer() {
        return new Mac();
    }

    @Override
    public Iphone createPhone() {
        return new Iphone();
    }
}
