package tv.codely.shared.domain;

public interface Specification<T> {

    boolean isSatisfied(T entity);
}
