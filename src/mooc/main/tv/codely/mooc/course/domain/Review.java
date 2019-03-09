package tv.codely.mooc.course.domain;

final public class Review {
    private final ReviewId id;
    private final Rating   rating;
    private final Comment  comment;

    public Review(ReviewId id, Rating rating, Comment comment) {
        this.id      = id;
        this.rating  = rating;
        this.comment = comment;
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
}
