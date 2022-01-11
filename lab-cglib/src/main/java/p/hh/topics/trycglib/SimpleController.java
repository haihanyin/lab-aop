package p.hh.topics.trycglib;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {

    public static final String REMOTE_URL = "http://localhost:9999/remoteInfo";
    @Qualifier("restTemplate")
    @Autowired
    private RestTemplate restTemplate;

    @Qualifier("proxiedRestTemplate")
    @Autowired
    private RestTemplate proxiedRestTemplate;

    @GetMapping(value = "/remoteInfo")
    public String getRemoteInfo() {
        return restTemplate.getForEntity(REMOTE_URL, String.class).getBody();
    }

    @GetMapping(value = "/proxiedRemoteInfo")
    public String getRemoteInfoFromProxy() {
        return proxiedRestTemplate.getForEntity(REMOTE_URL, String.class).getBody();
    }
}
