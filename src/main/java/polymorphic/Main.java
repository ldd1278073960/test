package polymorphic;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import polymorphic.child.Cat;
import polymorphic.child.Dog;
import polymorphic.father.Animal;

import javax.annotation.Resource;

/**
 * @author Ldp
 * @date 2021/1/6
 */
public class Main {

    @Resource
    BeanFactory factory;

    @Test
    public void mainxx() {
        this.run();
    }

    public void run(){
        Object bean = factory.getBean(Cat.class.getName());
    }

    public static void run1(Animal animal){
        if (animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.character();
            cat.eat();
        }else{
            Dog dog = (Dog) animal;
            dog.character();
            dog.eat();
        }
    }
}
