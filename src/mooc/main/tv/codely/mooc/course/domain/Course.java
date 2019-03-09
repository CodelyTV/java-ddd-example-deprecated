package tv.codely.mooc.course.domain;

import tv.codely.shared.domain.AggregateRoot;
import tv.codely.shared.domain.courses.CourseId;

final public class Course extends AggregateRoot {
    private final CourseId     id;
    private final CourseName   name;
    private final CourseRating rating;

    public Course(CourseId id, CourseName name, CourseRating rating) {
        this.id     = id;
        this.name   = name;
        this.rating = rating;
    }

    public CourseId id() {
        return id;
    }

    public CourseName name() {
        return name;
    }

    public CourseRating rating() {
        return rating;
    }
}
