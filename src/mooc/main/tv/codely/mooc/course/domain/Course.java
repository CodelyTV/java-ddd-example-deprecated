package tv.codely.mooc.course.domain;

import tv.codely.shared.domain.AggregateRoot;

import java.util.List;

final public class Course extends AggregateRoot {
    private final CourseId     id;
    private final CourseName   name;
    private final List<Review> reviews;

    public Course(CourseId id, CourseName name, List<Review> reviews) {
        this.id      = id;
        this.name    = name;
        this.reviews = reviews;
    }

    public CourseId id() {
        return id;
    }

    public CourseName name() {
        return name;
    }

    public List<Review> reviews() {
        return reviews;
    }
}
