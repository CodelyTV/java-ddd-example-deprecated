package tv.codely.mooc.log.domain;

import tv.codely.shared.domain.GeneratorMother;

public class LogVideoTitleMother {
    static LogVideoTitle random() {
        return new LogVideoTitle(GeneratorMother.generator().book().title());
    }

}