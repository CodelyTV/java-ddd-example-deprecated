package tv.codely.mooc.review.domain;

import tv.codely.shared.domain.students.StudentId;

final public class Review {
    private final ReviewId      id;
    private final StudentId     studentId;
    private final ReviewRating  rating;
    private final ReviewComment comment;

    public Review(ReviewId id, StudentId studentId, ReviewRating rating, ReviewComment comment) {
        this.id        = id;
        this.studentId = studentId;
        this.rating    = rating;
        this.comment   = comment;
    }

    public ReviewId id() {
        return id;
    }

    public StudentId studentId() {
        return studentId;
    }

    public ReviewRating rating() {
        return rating;
    }

    public ReviewComment comment() {
        return comment;
    }
}
