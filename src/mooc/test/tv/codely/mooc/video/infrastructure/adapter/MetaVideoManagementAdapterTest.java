package tv.codely.mooc.video.infrastructure.adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tv.codely.mooc.video.domain.exception.RuntimeServiceException;

import java.net.HttpURLConnection;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
class MetaVideoManagementAdapterTest {

    @InjectMocks
    private MetaVideoManagementAdapter metaVideoManagementAdapterTested;

    @Mock
    private HttpURLConnection httpUrlConnectionMock;

    @BeforeEach
    public void setUp() {
        this.httpUrlConnectionMock.setDoOutput(true);
    }

    @Test
    @DisplayName("should return error when video parameter is empty")
    void should_return_error_when_video_parameter_is_empty() {

        // Arrange

        // Action - Assert
        assertThatThrownBy(() -> metaVideoManagementAdapterTested.publish(null))
                .isInstanceOf(RuntimeServiceException.class)
                .hasMessage("The video is empty");

    }

//    // TODO - Acabar de reviar como hacer le mock del HttpUrlConnection para poder probar el código, imposible llevar a cabo el TDD
//    //
//
//    @Test
//    @DisplayName("should return error connection when client not response")
//    void should_return_error_connection_when_client_not_response() throws IOException {
//
//        // Arrange
//        this.httpUrlConnectionMock.setDoOutput(true);
//        metaVideoManagementAdapterTested.setConnection(httpUrlConnectionMock);
//        final Video videoMock = Video.builder()
//                .title(VideoTitle.builder().value("title").build())
//                .description(VideoDescription.builder().value("description").build())
//                .build();
//        when(httpUrlConnectionMock.getResponseCode()).thenReturn(509);
//
//        // Action - Assert
//        assertThatThrownBy(() -> metaVideoManagementAdapterTested.publish(videoMock))
//                .isInstanceOf(RuntimeServiceException.class)
//                .hasMessage("Error connection");
//
//        // Assert
//    }
}
