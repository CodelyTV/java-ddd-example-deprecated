package tv.codely.mooc.log.domain;

public class LogVideoStrings {

    private final String title;
    private final String description;

    public LogVideoStrings(String title, String description) {
        // nothing
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