package tv.codely.mooc.log.infrastructure;

public class LoggedVideo {

    private final String title;
    private final String description;

    public LoggedVideo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
