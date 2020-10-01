package tv.codely.mooc.notification.application.update;

import tv.codely.mooc.video.domain.VideoDescriptionUpdated;
import tv.codely.shared.application.DomainEventSubscriber;

public class SendPushToSubscribersOnVideoDescriptionUpdated implements DomainEventSubscriber<VideoDescriptionUpdated> {
    @Override
    public Class<VideoDescriptionUpdated> subscribedTo() {
        return VideoDescriptionUpdated.class;
    }

    @Override
    public void consume(VideoDescriptionUpdated event) {
        System.out.println(
            String.format(
                "Hey! Video with title <%s> now has description <%s>",
                event.title(),
                event.description()
            )
        );
    }
}
