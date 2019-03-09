package tv.codely.mooc.course.domain;

import tv.codely.shared.domain.students.StudentId;

final public class Review {
    private final ReviewId  id;
    private final Rating    rating;
    private final Comment   comment;
    private final StudentId studentId;

    public Review(ReviewId id, Rating rating, Comment comment, StudentId studentId) {
        this.id        = id;
        this.rating    = rating;
        this.comment   = comment;
        this.studentId = studentId;
    }

    public ReviewId id() {
        return id;
    }

    public Rating rating() {
        return rating;
    }

    public Comment comment() {
        return comment;
    }

    public StudentId studentId() {
        return studentId;
    }
}
