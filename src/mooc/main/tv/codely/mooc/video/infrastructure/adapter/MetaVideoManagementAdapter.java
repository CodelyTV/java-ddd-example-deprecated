package tv.codely.mooc.video.infrastructure.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import tv.codely.mooc.video.domain.Video;
import tv.codely.mooc.video.domain.exception.RuntimeServiceException;
import tv.codely.mooc.video.domain.port.VideoManagementPort;
import tv.codely.mooc.video.infrastructure.dto.youtube.VideoResourceDTO;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

@Log4j2
public class MetaVideoManagementAdapter implements VideoManagementPort {

    private static final String YOUTUBE_UPLOAD_URL = "https://youtube.googleapis.com/youtube/v3/videos?part=requestPArt&autoLevels=true&uploadType=mp4&key=TokeApiKey";
    private static final String YOUTUBE_API_ACCESS_TOKEN = "BearerTokeApiKey";
    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_ACCEPT = "Accept";
    private static final String HEADER_CONTENT_TYPE = "Content-Type";
    private static final String POST_METHOD = "POST";
    private static final String APPLICATION_JSON = "application/json";

    @Setter
    private HttpURLConnection connection;

    @Override
    public void publish(final Video video) {

        validateParameters(video);

        try {
            final URL url = new URL(YOUTUBE_UPLOAD_URL);
            connection = getHttpURLConnection(url);
            final String bodyJson = retrieveBodyJson(video);

            injectBodyInConnection(connection, bodyJson);

            if (connection.getResponseCode() != 200) {
                log.error("Failed : HTTP error code : " + connection.getResponseCode());
                throw new RuntimeServiceException("Error connection");
            }

            connection.disconnect();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    private void validateParameters(final Video video) {
        if (Objects.isNull(video)
                || Objects.isNull(video.getTitle())
                || Objects.isNull(video.getDescription())) {
            throw new RuntimeServiceException("The video is empty");
        }
    }

    private void injectBodyInConnection(final HttpURLConnection conn, final String bodyJson) throws IOException {
        OutputStream os = conn.getOutputStream();
        os.write(bodyJson.getBytes());
        os.flush();
    }

    private String retrieveBodyJson(final Video video) throws JsonProcessingException {
        final VideoResourceDTO videoResourceDTO = mapVideoToVideResource(video);
        return new ObjectMapper().writeValueAsString(videoResourceDTO);
    }

    private VideoResourceDTO mapVideoToVideResource(final Video video) {
        return VideoResourceDTO.builder()
                .fileDetails(VideoResourceDTO.FileDetailsDTO.builder()
                        .name(video.getTitle().getValue())
                        .container(video.getDescription().getValue())
                        .build())
                .build();
    }

    private HttpURLConnection getHttpURLConnection(final URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(POST_METHOD);
        conn.setRequestProperty(HEADER_AUTHORIZATION, YOUTUBE_API_ACCESS_TOKEN);
        conn.setRequestProperty(HEADER_ACCEPT, APPLICATION_JSON);
        conn.setRequestProperty(HEADER_CONTENT_TYPE, APPLICATION_JSON);
        return conn;
    }
}
