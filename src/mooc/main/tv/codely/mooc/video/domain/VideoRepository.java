package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.Identity;
import tv.codely.shared.domain.Repository;
import tv.codely.shared.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface VideoRepository extends Repository<Video> {

    void save(Video video);

    Optional<Video> search(Identity<?> title);

    List<Video> matching(Specification<Video> specification);

    Stream<Video> all();
}
