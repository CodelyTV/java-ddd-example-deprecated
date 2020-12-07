package tv.codely.mooc.video.infrastructure;

import tv.codely.mooc.video.domain.ExternalAPI;

public class SlackAPI implements ExternalAPI {

    @Override
    public void publish(String video) {

        System.out.println(
                String.format(
                        "Slack Said: there is a new video: %s!",
                        video
                )
        );
    }
}
