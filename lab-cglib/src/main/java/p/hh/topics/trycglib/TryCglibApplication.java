package p.hh.topics.trycglib;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TryCglibApplication {

    public static void main(String[] args) {
        SpringApplication.run(TryCglibApplication.class, args);
    }

    @Configuration
    public static class TryCglibApplicationConfiguration {

        @Bean(name = "proxiedRestTemplate")
        public RestTemplate proxiedRestTemplate(RestTemplate restTemplate) {
            final Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(RestTemplate.class);
            final GetEntityInterceptor interceptor = new GetEntityInterceptor(restTemplate);
            enhancer.setCallback(interceptor);
            return (RestTemplate) enhancer.create();
        }

        @Bean(name = "restTemplate")
        public RestTemplate restTemplate() {
            HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
            httpRequestFactory.setReadTimeout(2000);
            return new RestTemplate(httpRequestFactory);
        }

    }
}
