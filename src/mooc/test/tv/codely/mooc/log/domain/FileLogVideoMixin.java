package tv.codely.mooc.log.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import tv.codely.mooc.log.infrastructure.LoggedVideo;

public abstract class FileLogVideoMixin {
    @JsonCreator
    public FileLogVideoMixin(@JsonProperty("video") LoggedVideo video, @JsonProperty("action") String action) {
        // nothing
    }
}
