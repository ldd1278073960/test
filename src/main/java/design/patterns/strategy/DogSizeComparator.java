package design.patterns.strategy;

/**
 * @author Ldp
 * @date 2021/11/17
 */
public class DogSizeComparator implements Comparator<Dog> {


    @Override
    public Integer compareTo(Dog o1, Dog o2) {
        if ((o1.size ) < (o2.size)) return -1;
        else if ((o1.size) == (o2.size)) return 0;
        else return 1;
    }
}
