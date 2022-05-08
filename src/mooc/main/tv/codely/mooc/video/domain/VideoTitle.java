package tv.codely.mooc.video.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public final class VideoTitle {
    private final String value;

}
