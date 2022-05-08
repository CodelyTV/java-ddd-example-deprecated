package tv.codely.mooc.video.infrastructure.dto.youtube;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VideoResourceDTO {
    private FileDetailsDTO fileDetails;

    @Data
    @Builder
    public static class FileDetailsDTO {
        private String name;
        private String container;
    }
}
