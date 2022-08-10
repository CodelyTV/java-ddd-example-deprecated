package tv.codely.mooc.video.infrastructure;

import java.time.Instant;
import tv.codely.mooc.video.domain.ServiceAPI;

public class CustomServiceAPI implements ServiceAPI {

    public Instant create() {
        return Instant.now();
    }
}
