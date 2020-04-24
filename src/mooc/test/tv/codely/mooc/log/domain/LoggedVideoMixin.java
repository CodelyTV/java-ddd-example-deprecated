package tv.codely.mooc.log.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class LoggedVideoMixin {
    @JsonCreator
    public LoggedVideoMixin(@JsonProperty("title") String title, @JsonProperty("description") String description) {
        // nothing
    }
}
