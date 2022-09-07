package design.patterns.factory.abstractfactory;

import design.patterns.factory.abstractfactory.computer.AbstractComputerFactory;
import design.patterns.factory.abstractfactory.computer.Mac;
import design.patterns.factory.abstractfactory.phone.AbstractPhoneFactory;
import design.patterns.factory.abstractfactory.phone.Iphone;

/**
 * @author Ldp
 * @date 2021/11/23
 */
public abstract class AbstractElectronicProductFactory {

    public abstract AbstractComputerFactory createComputer();

    public abstract AbstractPhoneFactory createPhone();
}
