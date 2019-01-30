package tv.codely;

import tv.codely.context.notification.module.push.application.create.SendPushToSubscribersOnVideoCreated;
import tv.codely.context.video.module.video.domain.VideoCreated;
import tv.codely.shared.infrastructure.bus.ReactorEventBus;

import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
        var sendPushToSubscribersOnVideoCreated = new SendPushToSubscribersOnVideoCreated();

        var eventBus = new ReactorEventBus(Arrays.asList(sendPushToSubscribersOnVideoCreated));

        eventBus.notify(new VideoCreated("Llegamos a 1M de subscribers!", "CodelyTV es una gran plataforma, CREMITA!"));
    }
}
