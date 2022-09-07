package design.patterns.strategy;

import lombok.ToString;

/**
 * @author Ldp
 * @date 2021/11/15
 */
@ToString
public class Cart implements Comparable<Cart>{

    int weight,height;

    public Cart(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    @Override
    public int compareTo(Cart cart) {
        if ((cart.height + cart.weight) < (this.height + this.weight)) return -1;
        else if ((cart.height + cart.weight) == (this.height + this.weight)) return 0;
        else return 1;
    }
}
