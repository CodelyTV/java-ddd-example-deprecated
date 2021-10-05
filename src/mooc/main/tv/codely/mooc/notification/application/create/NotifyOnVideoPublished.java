package tv.codely.mooc.notification.application.create;

import tv.codely.mooc.notification.domain.Notifier;
import tv.codely.mooc.video.domain.VideoPublished;
import tv.codely.shared.application.DomainEventSubscriber;

public class NotifyOnVideoPublished implements DomainEventSubscriber<VideoPublished> {
	private final Notifier notifier;

	public NotifyOnVideoPublished(Notifier notifier) {
		this.notifier = notifier;
	}

	@Override
	public Class<VideoPublished> subscribedTo() {
		return VideoPublished.class;
	}

	@Override
	public void consume(VideoPublished event) {
		notifier.notify(String.format(
			"Hey! There is a new video with title <%s> and description <%s>",
			event.title(),
			event.description()
		));
	}
}
