package design.patterns.strategy;

/**
 * @author Ldp
 * @date 2021/11/17
 */
public interface Comparator<T> {

    /**
     * ddd
     * @param o1 参数1
     * @param o2 参数2
     */
    Integer compareTo(T o1,T o2);

}
