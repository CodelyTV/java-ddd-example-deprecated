package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.GeneratorMother;

public class VideoDescriptionMother {
    static VideoDescription random() {
        return new VideoDescription(GeneratorMother.generator().chuckNorris().fact());
    }
}
