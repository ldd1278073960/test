package design.patterns.strategy;

import lombok.ToString;

/**
 * @author Ldp
 * @date 2021/11/15
 */
@ToString
public class Dog implements Comparable<Dog>{

    public int size;

    public Dog(int size) {
        this.size = size;
    }


    @Override
    public int compareTo(Dog d) {
        if ((d.size ) < (this.size)) return -1;
        else if ((d.size) == (this.size)) return 0;
        else return 1;
    }
}
