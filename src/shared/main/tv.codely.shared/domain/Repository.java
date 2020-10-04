package tv.codely.shared.domain;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Stream;

public interface Repository<T> {

    void save(T entity);

    Optional<T> search(Identity<?> id);

    Collection<T> matching(Specification<T> specification);

    Stream<T> all();
}
