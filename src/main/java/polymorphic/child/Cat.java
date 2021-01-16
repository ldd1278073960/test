package polymorphic.child;

import polymorphic.father.Animal;

/**
 * @author Ldp
 * @date 2021/1/6
 */
public class Cat extends Animal {

    public void eat(){
        System.out.println("吃鱼刺");
    }

    public void character(){
        System.out.println("蹲着尿尿");
    }

    public void animal(){
        System.out.println("猫咪");
    }

}
