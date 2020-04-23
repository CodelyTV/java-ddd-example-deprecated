package tv.codely.mooc.log.domain;

public class LogVideoMother {

    public static LogVideo random() {
        var title = LogVideoTitleMother.random();
        var description = LogVideoDescriptionMother.random();
        return new LogVideo(title, description);
    }

}