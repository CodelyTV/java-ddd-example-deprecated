package tv.codely.mooc.video.domain;

import tv.codely.shared.domain.GeneratorMother;

public class VideoTitleMother   {
    static VideoTitle random() {
        return new VideoTitle(GeneratorMother.generator().book().title());
    }

}
