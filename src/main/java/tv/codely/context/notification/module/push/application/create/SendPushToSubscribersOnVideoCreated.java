package tv.codely.context.notification.module.push.application.create;

import tv.codely.context.video.module.video.domain.VideoCreated;
import tv.codely.shared.application.DomainEventSubscriber;

public class SendPushToSubscribersOnVideoCreated implements DomainEventSubscriber<VideoCreated> {
    @Override
    public String subscribedTo() {
        return VideoCreated.NAME;
    }

    @Override
    public void react(VideoCreated event) {
        System.out.println(
            String.format(
                "Hey! There is a new video with title <%s> and description <%s>",
                event.name(),
                event.description()
            )
        );
    }
}
