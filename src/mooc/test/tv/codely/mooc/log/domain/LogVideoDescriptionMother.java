package tv.codely.mooc.log.domain;

import tv.codely.shared.domain.GeneratorMother;

public class LogVideoDescriptionMother {
    static LogVideoDescription random() {
        return new LogVideoDescription(GeneratorMother.generator().chuckNorris().fact());
    }
}