package tv.codely.mooc.log.domain;

public class LogAction {
    private final String value;

    public LogAction(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
