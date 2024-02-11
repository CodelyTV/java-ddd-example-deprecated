package tv.codely.mooc.twitter.application;

public final class TwitterRequest {
    private String id;
    private String text;

    public TwitterRequest(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public TwitterRequest(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
