package domain.framework.rules;

public interface Rule<E, T> {

    boolean matches(E e, T t);

    void apply(E e, T t);

}
