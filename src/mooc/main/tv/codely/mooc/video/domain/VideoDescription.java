package tv.codely.mooc.video.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class VideoDescription {
    private final String value;

}
