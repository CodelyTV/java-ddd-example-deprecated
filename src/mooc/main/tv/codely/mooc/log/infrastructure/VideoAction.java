package tv.codely.mooc.log.infrastructure;

public enum VideoAction {
    PUBLISHED("published");

    private final String value;

    VideoAction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static String finalValueOf(String name) {
        return VideoAction.valueOf(name.toUpperCase()).value();
    }
}
