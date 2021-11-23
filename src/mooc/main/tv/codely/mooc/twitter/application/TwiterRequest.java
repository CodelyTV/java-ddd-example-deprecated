package tv.codely.mooc.twitter.application;

public final class TwiterRequest {
    private String id;
    private String text;

    public TwiterRequest(String id, String text) {
        this.id = id;
        this.text = text;
    }

    public TwiterRequest(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
