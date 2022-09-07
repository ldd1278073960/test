package design.patterns.factory.abstractfactory;

import design.patterns.factory.abstractfactory.computer.AbstractComputerFactory;
import design.patterns.factory.abstractfactory.phone.AbstractPhoneFactory;

/**
 * @author Ldp
 * @date 2021/11/22
 */
public class Main  {

    public static void main(String[] args) {
        AbstractElectronicProductFactory a = new MacFactory();
        AbstractPhoneFactory phone = a.createPhone();
        phone.name();

        AbstractComputerFactory computerFactory = a.createComputer();
        computerFactory.name();
    }
}
