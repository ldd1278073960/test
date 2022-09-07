package generic;

/**
 * @author Ldp
 * @date 2021/8/27
 */
public class Generic<T> {

    private T name;

    private T age;

    public Generic(T name, T age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }
}
