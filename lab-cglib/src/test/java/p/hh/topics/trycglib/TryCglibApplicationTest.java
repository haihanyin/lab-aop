package p.hh.topics.trycglib;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class TryCglibApplicationTest {

    @Test
    public void testPlainRestTemplate() {
        callRemoteService("http://localhost:8080/remoteInfo", 5);
    }

    @Test
    public void testProxiedRestTemplate() {
        callRemoteService("http://localhost:8080/proxiedRemoteInfo", 5);
    }

    private void callRemoteService(String url, int count) {
        final RestTemplate restTemplate = new RestTemplate();
        for (int i = 0; i < count; i++) {
            try {
                restTemplate.getForEntity(url, String.class);
            } catch (Exception e) {
                System.out.println("####" + e.getMessage());
            }
        }
    }
}
