package polymorphic.child;

import polymorphic.father.Animal;

/**
 * @author Ldp
 * @date 2021/1/6
 */
public class Dog extends Animal {

    public void eat(){
        System.out.println("吃屎");
    }

    public void character(){
        System.out.println("翘腿尿尿");
    }

    public void animal(){
        System.out.println("狗狗");
    }

}
