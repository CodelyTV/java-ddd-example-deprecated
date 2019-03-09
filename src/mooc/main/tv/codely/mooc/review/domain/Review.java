package tv.codely.mooc.review.domain;

import tv.codely.shared.domain.courses.CourseId;
import tv.codely.shared.domain.students.StudentId;

final public class Review {
    private final ReviewId      id;
    private final StudentId     studentId;
    private final CourseId      courseId;
    private final ReviewRating  rating;
    private final ReviewComment comment;

    public Review(ReviewId id, StudentId studentId, CourseId courseId, ReviewRating rating, ReviewComment comment) {
        this.id        = id;
        this.studentId = studentId;
        this.courseId  = courseId;
        this.rating    = rating;
        this.comment   = comment;
    }

    public ReviewId id() {
        return id;
    }

    public StudentId studentId() {
        return studentId;
    }

    public CourseId courseId() {
        return courseId;
    }

    public ReviewRating rating() {
        return rating;
    }

    public ReviewComment comment() {
        return comment;
    }
}
