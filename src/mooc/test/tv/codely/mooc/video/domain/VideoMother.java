package tv.codely.mooc.video.domain;

public class VideoMother {

    public static Video random() {
        var title = VideoTitleMother.random();
        var description = VideoDescriptionMother.random();
        return Video.build(title, description);
    }

}