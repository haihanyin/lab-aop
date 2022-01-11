package p.hh.topics.trycglib;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

public class RemoteServerMain {

    public static void main(String[] args) {
        WireMockServer wireMockServer = new WireMockServer(9999);
        wireMockServer.stubFor(WireMock.get("/remoteInfo")
                .willReturn(WireMock.aResponse()
                        .withFixedDelay(8000)  // slow response!
                        .withStatus(200)
                        .withBody("hello, world!"))
        );
        wireMockServer.start();
    }

}
