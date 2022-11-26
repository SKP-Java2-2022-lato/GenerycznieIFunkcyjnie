package lambda;

@FunctionalInterface
public interface Checker<T> {
    boolean check(T object);

}
